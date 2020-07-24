package com.example.netology_hw_3.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.netology_hw_3.adatpter.PostAdapter
import com.example.netology_hw_3.entity.Post

abstract class BaseViewHolder(adapter: PostAdapter, view : View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(post:Post)
}