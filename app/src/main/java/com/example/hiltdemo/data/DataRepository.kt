package com.example.hiltdemo.data

import com.example.hiltdemo.data.entity.Word
import java.util.concurrent.Executors
import javax.inject.Inject

class DataRepository @Inject constructor(appDB: AppDB) {

    private val wordDao = appDB.wordDao()

    private val executor = Executors.newSingleThreadExecutor()

    fun insert(word: Word) {
        executor.execute {
            wordDao.insert(word)
        }
    }

    fun getAllWords() = wordDao.getAllWords()

}