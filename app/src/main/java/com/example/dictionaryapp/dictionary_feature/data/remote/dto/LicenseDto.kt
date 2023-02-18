package com.example.dictionaryapp.dictionary_feature.data.remote.dto // ktlint-disable package-name

import com.example.dictionaryapp.dictionary_feature.domain.model.License

data class LicenseDto(
    val name: String,
    val url: String
) {
    fun toLicense(): License {
        return License(
            name = name,
            url = url
        )
    }
}
