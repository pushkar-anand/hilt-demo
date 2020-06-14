package com.example.hiltdemo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hiltdemo.data.dao.WordDao
import com.example.hiltdemo.data.entity.Word

@Database(entities = [Word::class], version = 1, exportSchema = false)
abstract class AppDB : RoomDatabase() {
    abstract fun wordDao(): WordDao
}