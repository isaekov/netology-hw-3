package com.example.netology_hw_3.adatpter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.netology_hw_3.R
import com.example.netology_hw_3.entity.Post
import com.example.netology_hw_3.entity.PostType
import com.example.netology_hw_3.view.*

const val VIEW_REPOST = 0
const val VIEW_POST = 1
const val VIEW_EVENT_POST = 2
const val VIEW_VIDEO_POST = 3
const val VIEW_AD_POST = 4


class PostAdapter(val items: List<Post>) : RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= when (viewType) {

        VIEW_REPOST -> PostRepostViewHolder(this, LayoutInflater.from(parent.context).inflate(
            R.layout.repost_item, parent, false
        ))

        VIEW_POST -> PostViewHolder(this, LayoutInflater.from(parent.context).inflate(
            R.layout.post_item, parent, false
        ))

        VIEW_AD_POST -> AdPostViewHolder(this, LayoutInflater.from(parent.context).inflate(
            R.layout.ad_post_item, parent, false
        ))

        VIEW_VIDEO_POST -> PostVideoViewHolder(this, LayoutInflater.from(parent.context).inflate(
            R.layout.video_post_item, parent, false
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
            PostType.POST -> VIEW_POST
            PostType.REPOST_POST -> VIEW_REPOST
            PostType.AD_POST -> VIEW_AD_POST
            PostType.EVENT_POST -> VIEW_EVENT_POST
            PostType.VIDEO_POST -> VIEW_VIDEO_POST
    }


}