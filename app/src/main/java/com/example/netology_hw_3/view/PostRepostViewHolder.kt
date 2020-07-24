package com.example.netology_hw_3.view

import android.content.Intent
import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.netology_hw_3.R
import com.example.netology_hw_3.adatpter.PostAdapter
import com.example.netology_hw_3.entity.Post
import com.example.netology_hw_3.util.Helper
import kotlinx.android.synthetic.main.repost_item.view.*
import kotlinx.android.synthetic.main.repost_item.view.authorTv
import kotlinx.android.synthetic.main.repost_item.view.commentCountTv
import kotlinx.android.synthetic.main.repost_item.view.commentIv
import kotlinx.android.synthetic.main.repost_item.view.contentTv
import kotlinx.android.synthetic.main.repost_item.view.createdTv
import kotlinx.android.synthetic.main.repost_item.view.likeCountTv
import kotlinx.android.synthetic.main.repost_item.view.likeIv
import kotlinx.android.synthetic.main.repost_item.view.shareIv

class PostRepostViewHolder(private val adapter: PostAdapter, view: View):BaseViewHolder(adapter, view) {
    override fun bind(post: Post) {
        init()
        with(itemView) {
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(post.post?.image)
                .into(itemView.repostImg)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(post.image)
                .into(itemView.avatarIv)

            repostAuthor.text = post.post?.authorName
            itemView.createdTv.text = Helper.timing(post.createDate)
            itemView.authorTv.text = post.authorName
            itemView.contentTv.text = """repost"""

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
        }
    }

    private fun init() = with(itemView) {
        val post = adapter.items[adapterPosition]
        likeIv.setOnClickListener {
            if (adapterPosition != RecyclerView.NO_POSITION) {
                initLike(post)
            }
        }
        shareIv.setOnClickListener {
            if (adapterPosition != RecyclerView.NO_POSITION) {
                val intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(
                        Intent.EXTRA_TEXT, "${post.authorName} - ${Helper.timing(post.createDate)} ${post.content}"
                    )
                    type = "text/plain"
                }
                itemView.context.startActivity(intent)
            }
        }
    }

    private fun initLike(post: Post) {
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