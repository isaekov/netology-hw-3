package com.example.netology_hw_3.adatpter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.netology_hw_3.R
import com.example.netology_hw_3.entity.*
import com.example.netology_hw_3.view.*




class PostAdapter(val items: List<Post>) : RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= when (viewType) {

        REPOST -> PostRepostViewHolder(this, LayoutInflater.from(parent.context).inflate(
            R.layout.repost_item, parent, false
        ))

        POST -> PostViewHolder(this, LayoutInflater.from(parent.context).inflate(
            R.layout.post_item, parent, false
        ))

        AD_POST -> AdPostViewHolder(this, LayoutInflater.from(parent.context).inflate(
            R.layout.ad_post_item, parent, false
        ))

        VIDEO_POST -> PostVideoViewHolder(this, LayoutInflater.from(parent.context).inflate(
            R.layout.video_post_item, parent, false
        ))

        EVENT_POST -> PostEventViewHolder(this, LayoutInflater.from(parent.context).inflate(
            R.layout.event_post_item, parent, false
        ))

        else -> throw IllegalArgumentException("Неподдерживаемый макет")

    }

    override fun getItemId(position: Int) = items[position].id


    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder as BaseViewHolder) {
            bind(items[position])
        }
    }

    override fun getItemViewType(position: Int) = when (items[position].postType) {
            PostType.POST -> POST
            PostType.REPOST_POST -> REPOST
            PostType.AD_POST -> AD_POST
            PostType.EVENT_POST -> EVENT_POST
            PostType.VIDEO_POST -> VIDEO_POST
    }


}