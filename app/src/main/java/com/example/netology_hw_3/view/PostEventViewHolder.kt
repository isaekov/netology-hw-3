package com.example.netology_hw_3.view

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.netology_hw_3.R
import com.example.netology_hw_3.entity.Post
import com.example.netology_hw_3.entity.PostEvent
import com.example.netology_hw_3.util.Helper
import kotlinx.android.synthetic.main.blog_item.view.*

class PostEventViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(postEvent : Post)  {
        showMap(postEvent)
        val requestOptions = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)

        Glide.with(itemView.context)
            .applyDefaultRequestOptions(requestOptions)
            .load(postEvent.image)
            .into(itemView.avatarIv)

        itemView.createdTv.text = Helper.timing(postEvent.createDate)
        itemView.authorTv.text = postEvent.authorName
        itemView.contentTv.text = postEvent.content

        if (postEvent.likeMe) {
            itemView.shareIv.setImageResource(R.drawable.ic_baseline_favorite_disabled)
            itemView.likeCountTv.setTextColor(Color.DKGRAY)
            postEvent.likeMe = false
            postEvent.likeCount --
            itemView.likeCountTv.text = postEvent.likeCount.toString()
            if (postEvent.likeCount < 1) {
                itemView.likeCountTv.visibility = View.GONE
            }
        } else {
            itemView.likeIv.setImageResource(R.drawable.ic_baseline_favorite_active)
            itemView.likeCountTv.setTextColor(Color.RED)
            postEvent.likeCount ++
            if (!itemView.likeCountTv.isShown) {
                itemView.likeCountTv.visibility = View.VISIBLE
            }
            itemView.likeCountTv.text = postEvent.likeCount.toString()
            postEvent.likeMe = true
        }

        if (postEvent.commentCount > 0) {
            itemView.commentCountTv.text = postEvent.commentCount.toString()
            if (postEvent.commentMe) {
                itemView.commentIv.setImageResource(R.drawable.ic_baseline_mode_comment_active)
                itemView.commentCountTv.setTextColor(Color.RED)
            }
        } else {
            itemView.commentCountTv.visibility = View.GONE
        }

        if (postEvent.shareCount > 0) {
            itemView.shareCountTv.text = postEvent.shareCount.toString()
            if (postEvent.shareMe) {
                itemView.shareIv.setImageResource(R.drawable.ic_baseline_share_active)
                itemView.shareCountTv.setTextColor(Color.RED)
            }
        } else {
            itemView.shareCountTv.visibility = View.GONE
        }
    }

    private fun showMap(post: Post) {
        if (post is PostEvent) {
            itemView.location.visibility = View.VISIBLE
            itemView.location.setOnClickListener {
                val intent = Intent().apply {
                    action = Intent.ACTION_VIEW
                    data =
                        Uri.parse("geo:${post.coordinates.latitude},${post.coordinates.longitude}")
                }
                itemView.context.startActivity(intent)
            }
        }
    }

    }
