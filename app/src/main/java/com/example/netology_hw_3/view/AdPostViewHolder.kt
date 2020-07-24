package com.example.netology_hw_3.view

import android.graphics.Color
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.netology_hw_3.R
import com.example.netology_hw_3.adatpter.PostAdapter
import com.example.netology_hw_3.entity.Post
import kotlinx.android.synthetic.main.ad_post_item.view.*

class AdPostViewHolder(adapter: PostAdapter, view: View) : BaseViewHolder(adapter, view) {

    override fun bind(post: Post) {

        Glide.with(itemView.context)
            .load(post.image)
            .apply(RequestOptions().placeholder(R.drawable.ic_launcher_background))
            .into(itemView.imageHead)

        Glide.with(itemView.context)
            .load(post.image)
            .apply(RequestOptions().placeholder(R.drawable.ic_launcher_background))
            .into(itemView.imageContent)

        itemView.textHead.text = post.adHead
        itemView.textAd.text = "Реклама"
        click(post)

        if (post.repostMe) {
            itemView.repost.setImageResource(R.drawable.ic_reply_active_24)
        } else {
            itemView.repost.setImageResource(R.drawable.ic_reply_24)
        }

        itemView.repost.setOnClickListener {
            if (post.repostMe) {
                itemView.repost.setImageResource(R.drawable.ic_reply_24)
                post.repostMe = false
            } else {
                itemView.repost.setImageResource(R.drawable.ic_reply_active_24)
                post.repostMe = true
            }
        }
        itemView.likeIv.setOnClickListener {
            click(post)
        }
    }

    private fun click(post: Post) {
        if (post.likeMe) {
            itemView.likeIv.setImageResource(R.drawable.ic_baseline_favorite_disabled)
            itemView.likeCountTv.setTextColor(Color.DKGRAY)
            post.likeMe = false
            post.likeCount--
            itemView.likeCountTv.text = post.likeCount.toString()
            if (post.likeCount < 1) {
                itemView.likeCountTv.visibility = View.GONE
            }
        } else {
            itemView.likeIv.setImageResource(R.drawable.ic_baseline_favorite_active)
            itemView.likeCountTv.setTextColor(Color.RED)
            post.likeCount++
            if (!itemView.likeCountTv.isShown) {
                itemView.likeCountTv.visibility = View.VISIBLE
            }
            itemView.likeCountTv.text = post.likeCount.toString()
            post.likeMe = true
        }
    }

}