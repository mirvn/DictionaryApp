package com.example.dictionaryapp.dictionary_feature.data.local.entity // ktlint-disable package-name

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dictionaryapp.dictionary_feature.domain.model.License
import com.example.dictionaryapp.dictionary_feature.domain.model.Meaning
import com.example.dictionaryapp.dictionary_feature.domain.model.WordInfo

@Entity
data class WordInfoEntity(
    val license: License?,
    // SQL Room can't handle for list of another data class, so we are using util
    val meanings: List<Meaning>?,
    val phonetic: String?,
    val sourceUrls: List<String>?,
    val word: String?,
    @PrimaryKey val id: Int? = null
) {
    // mapper function
    fun toWordInfo(): WordInfo {
        return WordInfo(
            license = license,
            meanings = meanings,
            phonetic = phonetic,
            sourceUrls = sourceUrls,
            word = word
        )
    }
}
