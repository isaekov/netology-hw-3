package com.example.netology_hw_3.view

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.netology_hw_3.R
import com.example.netology_hw_3.adatpter.PostAdapter
import com.example.netology_hw_3.entity.Post
import com.example.netology_hw_3.util.Helper
import kotlinx.android.synthetic.main.event_post_item.view.*

class PostEventViewHolder(adapter: PostAdapter, view: View) :
    BaseViewHolder(view = view) {

    override fun bind(post: Post) {
        showMap(post)
        val requestOptions = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
        Glide.with(itemView.context)
            .applyDefaultRequestOptions(requestOptions)
            .load(post.image)
            .into(itemView.avatarIv)

        click(post)
        itemView.createdTv.text = Helper.timing(post.createDate)
        itemView.authorTv.text = post.authorName
        itemView.imageContent.text = post.content
        itemView.address.text = post.address


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
                itemView.repost.setImageResource(R.drawable.ic_baseline_share_active)
                itemView.shareCountTv.setTextColor(Color.RED)
            }
        } else {
            itemView.shareCountTv.visibility = View.GONE
        }

        itemView.likeIv.setOnClickListener {
            click(post)
        }
    }

    private fun showMap(post: Post) {

        if (adapterPosition != RecyclerView.NO_POSITION) {
            itemView.location.visibility = View.VISIBLE
            itemView.location.setOnClickListener {
                val intent = Intent().apply {
                    action = Intent.ACTION_VIEW
                    data =
                        Uri.parse("geo:${post.coordinates?.latitude},${post.coordinates?.longitude}")
                }
                itemView.context.startActivity(intent)
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
