package com.example.hiltdemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hiltdemo.R
import com.example.hiltdemo.data.entity.Word
import com.example.hiltdemo.viewholder.WordHolder

class WordAdapter : RecyclerView.Adapter<WordHolder>() {

    private var wordList = emptyList<Word>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = WordHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
    )


    override fun getItemCount() = wordList.size

    override fun onBindViewHolder(holder: WordHolder, position: Int) {
        val word = wordList[position]
        holder.setData(word)
    }

    fun setWordList(wordList: List<Word>) {
        this.wordList = wordList
        notifyDataSetChanged()
    }
}