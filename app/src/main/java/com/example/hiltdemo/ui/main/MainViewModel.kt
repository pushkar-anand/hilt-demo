package com.example.hiltdemo.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.hiltdemo.data.DataRepository

class MainViewModel @ViewModelInject constructor(
    repository: DataRepository
) : ViewModel() {
    val wordListLiveData = repository.getAllWords()
}