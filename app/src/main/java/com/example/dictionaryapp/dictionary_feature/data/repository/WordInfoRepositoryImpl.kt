package com.example.dictionaryapp.dictionary_feature.data.repository

import com.example.dictionaryapp.core.util.Resource
import com.example.dictionaryapp.dictionary_feature.data.local.WordInfoDao
import com.example.dictionaryapp.dictionary_feature.data.remote.DictionaryApi
import com.example.dictionaryapp.dictionary_feature.domain.model.WordInfo
import com.example.dictionaryapp.dictionary_feature.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class WordInfoRepositoryImpl(
    private val api: DictionaryApi,
    private val dao: WordInfoDao
) : WordInfoRepository {
    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow {
        // here we'll do to takes all the different data sources (api and db)
        // also decide which data will be shown on the UI
        // then when it come to caching, we should stick into single source principle, that means -
        // all the data we'll be showing in the UI come from DB, not direct from API
        // in short, we'll call the API then save to DB then from DB we pass it to the UI
        emit(Resource.Loading())

        val wordInfos = dao.getWordInfos(word).map {
            it.toWordInfo()
        }
        // in here we can pass the data from db while still in the Loading states
        emit(Resource.Loading(data = wordInfos))

        // make API call
        try {
            val remoteWordInfos = api.getWordInfo(word = word)
            dao.deleteWordInfos(remoteWordInfos.map { it.word })
            dao.insertWordInfos(remoteWordInfos.map { it.toWordInfoEntity() })
        } catch (e: HttpException) { // for invalid response
            emit(
                Resource.Error(
                    message = "Oops, something went wrong!",
                    data = wordInfos
                )
            )
        } catch (e: IOException) { // for parsing wrong / server wrong / no connection
            emit(
                Resource.Error(
                    message = "Could'nt reach server, please check your connection",
                    data = wordInfos
                )
            )
        }
        val newWordInfos = dao.getWordInfos(word).map { it.toWordInfo() }
        emit(Resource.Success(newWordInfos))
    }
}
