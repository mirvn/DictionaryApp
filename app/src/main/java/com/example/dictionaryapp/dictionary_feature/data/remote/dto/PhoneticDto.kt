package com.example.dictionaryapp.dictionary_feature.data.remote.dto

import com.example.dictionaryapp.dictionary_feature.domain.model.Phonetic

data class PhoneticDto(
    val audio: String,
    val license: LicenseDto,
    val sourceUrl: String,
    val text: String
) {
    fun toPhonetic(): Phonetic {
        return Phonetic(
            audio = audio,
            license = license.toLicense(),
            sourceUrl = sourceUrl,
            text = text
        )
    }
}
