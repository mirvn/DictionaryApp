package com.example.dictionaryapp.dictionary_feature.domain.usecase

import com.example.dictionaryapp.core.util.Resource
import com.example.dictionaryapp.dictionary_feature.domain.model.WordInfo
import com.example.dictionaryapp.dictionary_feature.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWordInfo(
    private val repository: WordInfoRepository
) {
    // using operator invoke function, that way we can call our usecase like function, even its a class
    operator fun invoke(word: String): Flow<Resource<List<WordInfo>>> {
        if (word.isBlank()) {
            return flow { }
        }
        return repository.getWordInfo(word)
    }
}
