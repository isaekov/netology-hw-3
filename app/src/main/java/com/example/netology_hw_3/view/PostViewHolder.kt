package com.example.netology_hw_3.view

import android.graphics.Color
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.netology_hw_3.R
import com.example.netology_hw_3.adatpter.PostAdapter
import com.example.netology_hw_3.entity.Post
import com.example.netology_hw_3.util.Helper
import kotlinx.android.synthetic.main.post_item.view.*

class PostViewHolder(adapter: PostAdapter, view: View) : BaseViewHolder(adapter, view) {

    override fun bind(post: Post) {

        Glide.with(itemView.context)
            .load(post.image)
            .apply(RequestOptions().placeholder(R.drawable.ic_launcher_background))
            .into(itemView.avatarIv)
        itemView.createdTv.text = Helper.timing(post.createDate)
        itemView.authorTv.text = post.authorName
        itemView.contentTv.text = post.content
        click(post)
        if (post.commentCount > 0) {
            itemView.commentCountTv.text = post.commentCount.toString()
            if (post.commentMe) {
                itemView.commentIv.setImageResource(R.drawable.ic_baseline_mode_comment_active)
                itemView.commentCountTv.setTextColor(Color.RED)
            }
        } else {
            itemView.commentCountTv.visibility = View.GONE
        }

        if (post.shareCount > 0) {
            itemView.shareCountTv.text = post.shareCount.toString()
            if (post.shareMe) {
                itemView.shareIv.setImageResource(R.drawable.ic_baseline_share_active)
                itemView.shareCountTv.setTextColor(Color.RED)
            }
        } else {
            itemView.shareCountTv.visibility = View.GONE
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
