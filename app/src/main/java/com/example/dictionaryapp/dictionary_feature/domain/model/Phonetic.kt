package com.example.dictionaryapp.dictionary_feature.domain.model

data class Phonetic(
    val audio: String,
    val license: License,
    val sourceUrl: String,
    val text: String
)
