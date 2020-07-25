package com.example.netology_hw_3.view

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.provider.MediaStore
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.netology_hw_3.R
import com.example.netology_hw_3.adatpter.PostAdapter
import com.example.netology_hw_3.entity.Post
import com.example.netology_hw_3.util.Helper
import kotlinx.android.synthetic.main.post_item.view.*
import kotlinx.android.synthetic.main.video_post_item.view.*
import kotlinx.android.synthetic.main.video_post_item.view.authorTv
import kotlinx.android.synthetic.main.video_post_item.view.avatarIv
import kotlinx.android.synthetic.main.video_post_item.view.commentCountTv
import kotlinx.android.synthetic.main.video_post_item.view.commentIv
import kotlinx.android.synthetic.main.video_post_item.view.createdTv
import kotlinx.android.synthetic.main.video_post_item.view.imageContent
import kotlinx.android.synthetic.main.video_post_item.view.likeCountTv
import kotlinx.android.synthetic.main.video_post_item.view.likeIv
import kotlinx.android.synthetic.main.video_post_item.view.repost

//https://img.youtube.com/vi/<insert-youtube-video-id-here>/0.jpg

class PostVideoViewHolder(adapter: PostAdapter, view: View) : BaseViewHolder(adapter, view) {
    override fun bind(post: Post) {

        Glide.with(itemView.context)
            .load(post.image)
            .apply(RequestOptions().placeholder(R.drawable.ic_launcher_background))
            .into(itemView.avatarIv)

        Glide.with(itemView.context)
            .load(post.adImageContent)
            .apply(RequestOptions().placeholder(R.drawable.ic_launcher_background))
            .into(itemView.imageContent)

        click(post)

        itemView.authorTv.text = post.authorName
        itemView.createdTv.text = Helper.timing(post.createDate)
        itemView.vidoeContent.text = post.content

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

        if (post.commentCount > 0) {
            itemView.commentCountTv.text = post.commentCount.toString()
            if (post.commentMe) {
                itemView.commentIv.setImageResource(R.drawable.ic_baseline_mode_comment_active)
                itemView.commentCountTv.setTextColor(Color.RED)
            }
        } else {
            itemView.commentCountTv.visibility = View.GONE
        }
        itemView.likeIv.setOnClickListener {
            click(post)
        }

        itemView.imageContent.setOnClickListener {
            if (adapterPosition != RecyclerView.NO_POSITION) {
                val intent = Intent().apply {
                    action = Intent.ACTION_VIEW
                    data = Uri.parse(post.videoUrl)
                }

                if (intent.resolveActivity(itemView.context.packageManager) != null) {
                    ContextCompat.startActivity(itemView.context, intent, null)
                }
            }
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