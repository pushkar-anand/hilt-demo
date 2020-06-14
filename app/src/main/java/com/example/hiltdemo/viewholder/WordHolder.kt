package com.example.hiltdemo.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hiltdemo.data.entity.Word
import kotlinx.android.synthetic.main.item.view.*

class WordHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val wordTV: TextView = itemView.wordTV

    fun setData(word: Word) {
        wordTV.text = word.word
    }
}