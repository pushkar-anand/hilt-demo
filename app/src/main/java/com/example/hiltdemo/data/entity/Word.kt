package com.example.hiltdemo.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Word(

    @PrimaryKey(autoGenerate = true)
    val id: Long,

    var word: String

)