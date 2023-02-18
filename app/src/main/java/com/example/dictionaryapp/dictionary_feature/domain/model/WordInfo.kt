package com.example.dictionaryapp.dictionary_feature.domain.model // ktlint-disable package-name

data class WordInfo(
    val license: License?,
    val meanings: List<Meaning>?,
    val phonetic: String?,
    val sourceUrls: List<String>?,
    val word: String?
)
