package com.example.hiltdemo.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hiltdemo.R
import com.example.hiltdemo.adapter.WordAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var wordAdapter: WordAdapter

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wordAdapter = WordAdapter()

        wordRV.apply {
            adapter = wordAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        mainViewModel.wordListLiveData.observe(this, Observer {
            wordAdapter.setWordList(it)
        })

    }
}