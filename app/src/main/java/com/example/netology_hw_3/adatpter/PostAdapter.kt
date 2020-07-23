package com.example.netology_hw_3.adatpter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.netology_hw_3.R
import com.example.netology_hw_3.entity.Article
import com.example.netology_hw_3.entity.Post
import com.example.netology_hw_3.entity.PostEvent
import com.example.netology_hw_3.view.PostArticleViewHolder
import com.example.netology_hw_3.view.PostEventViewHolder

class PostAdapter : RecyclerView.Adapter<ViewHolder>() {

    private var items: List<Post> = ArrayList()

    fun submit(post: List<Post>) {
        items = post
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            Article::class.java.name.hashCode() ->
                PostArticleViewHolder(inflater.inflate(R.layout.blog_item, parent, false))
            PostEvent::class.java.name.hashCode() ->
                PostEventViewHolder(inflater.inflate(R.layout.blog_item, parent, false))
            else -> throw IllegalArgumentException("Unsupported layout") // in case populated with a model we don't know how to display.
        }
    }


    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = items[position]
        when (holder) {
            is PostArticleViewHolder -> holder.bind(post)

            is PostEventViewHolder -> holder.bind(post)

        }
    }

    override fun getItemViewType(position: Int): Int {
        return items[position]::class.java.name.hashCode()

    }


}