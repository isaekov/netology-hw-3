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

class PostEventViewHolder(adapter:PostAdapter, view: View) : BaseViewHolder(view = view, adapter = adapter) {

    override fun bind(postEvent : Post)  {
//        showMap(postEvent)
        val requestOptions = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)

        Glide.with(itemView.context)
            .applyDefaultRequestOptions(requestOptions)
            .load(postEvent.image)
            .into(itemView.avatarIv)

        click(postEvent)
        itemView.createdTv.text = Helper.timing(postEvent.createDate)
        itemView.authorTv.text = postEvent.authorName
        itemView.imageContent.text = postEvent.content

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
                itemView.repost.setImageResource(R.drawable.ic_baseline_share_active)
                itemView.shareCountTv.setTextColor(Color.RED)
            }
        } else {
            itemView.shareCountTv.visibility = View.GONE
        }

        itemView.likeIv.setOnClickListener {
            click(postEvent)
        }
    }

//    private fun showMap(post: Post) {
//        if (post is Post) {
//            itemView.location.visibility = View.VISIBLE
//            itemView.location.setOnClickListener {
//                val intent = Intent().apply {
//                    action = Intent.ACTION_VIEW
//                    data =
//                        Uri.parse("geo:${post.coordinates.latitude},${post.coordinates.longitude}")
//                }
//                itemView.context.startActivity(intent)
//            }
//        }
//    }

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
