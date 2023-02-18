package com.example.dictionaryapp.dictionary_feature.data.util

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.dictionaryapp.dictionary_feature.domain.model.License
import com.example.dictionaryapp.dictionary_feature.domain.model.Meaning
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter // annotate class that using our own converter
class Converter(
    private val jsonParser: JsonParser
) {
    @TypeConverter // annotation from room for converter function
    fun fromMeaningsJson(json: String): List<Meaning> {
        return jsonParser.fromJson<ArrayList<Meaning>>(
            json,
            object : TypeToken<ArrayList<Meaning>>() {}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toMeaningsJson(meanings: List<Meaning>): String {
        return jsonParser.toJson(
            meanings,
            object : TypeToken<ArrayList<Meaning>>() {}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromSourceUrlsJson(json: String): List<String> {
        return jsonParser.fromJson<ArrayList<String>>(
            json,
            object : TypeToken<ArrayList<String>>() {}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toSourceUrlsJson(sourceUrls: List<String>): String? {
        return jsonParser.toJson(
            sourceUrls,
            object : TypeToken<ArrayList<String>>() {}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromLicenseJson(json: String): License {
        return jsonParser.fromJson<License>(
            json,
            object : TypeToken<License>() {}.type
        ) ?: License("", "")
    }

    @TypeConverter
    fun toSourceUrlsJson(license: License): String {
        return jsonParser.toJson(
            license,
            object : TypeToken<License>() {}.type
        ) ?: "[]"
    }
}
