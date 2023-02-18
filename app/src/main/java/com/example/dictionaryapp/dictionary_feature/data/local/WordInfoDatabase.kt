package com.example.dictionaryapp.dictionary_feature.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.dictionaryapp.dictionary_feature.data.local.entity.WordInfoEntity
import com.example.dictionaryapp.dictionary_feature.data.util.Converter

@Database(
    entities = [WordInfoEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converter::class)
abstract class WordInfoDatabase : RoomDatabase() {
    abstract val dao: WordInfoDao
}
