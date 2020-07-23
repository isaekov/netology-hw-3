package com.example.netology_hw_3.adatpter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.netology_hw_3.R
import com.example.netology_hw_3.entity.Article
import com.example.netology_hw_3.entity.Post
import com.example.netology_hw_3.entity.PostEvent
import com.example.netology_hw_3.util.Helper
import kotlinx.android.synthetic.main.blog_item.view.*

class PostAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<Post> = ArrayList()

    fun submit(post:List<Post>) {
        items = post
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PostArticleViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.blog_item, parent, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       when(holder) {
           is PostArticleViewHolder -> {
               holder.bind(items[position] as Article)
           }
       }
    }

    class PostArticleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(articleItem : Article)  {
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(articleItem.image)
                .into(itemView.avatarIv)

            itemView.createdTv.text = Helper.timing(articleItem.createDate)
            itemView.authorTv.text = articleItem.authorName
            itemView.contentTv.text = articleItem.content

            if (articleItem.likeMe) {
                itemView.shareIv.setImageResource(R.drawable.ic_baseline_favorite_disabled)
                itemView.likeCountTv.setTextColor(Color.DKGRAY)
                articleItem.likeMe = false
                articleItem.likeCount --
                itemView.likeCountTv.text = articleItem.likeCount.toString()
                if (articleItem.likeCount < 1) {
                    itemView.likeCountTv.visibility = View.GONE
                }
            } else {
                itemView.likeIv.setImageResource(R.drawable.ic_baseline_favorite_active)
                itemView.likeCountTv.setTextColor(Color.RED)
                articleItem.likeCount ++
                if (!itemView.likeCountTv.isShown) {
                    itemView.likeCountTv.visibility = View.VISIBLE
                }
                itemView.likeCountTv.text = articleItem.likeCount.toString()
                articleItem.likeMe = true
            }

            if (articleItem.commentCount > 0) {
                itemView.commentCountTv.text = articleItem.commentCount.toString()
                if (articleItem.commentMe) {
                    itemView.commentIv.setImageResource(R.drawable.ic_baseline_mode_comment_active)
                    itemView.commentCountTv.setTextColor(Color.RED)
                }
            } else {
                itemView.commentCountTv.visibility = View.GONE
            }

            if (articleItem.shareCount > 0) {
                itemView.shareCountTv.text = articleItem.shareCount.toString()
                if (articleItem.shareMe) {
                    itemView.shareIv.setImageResource(R.drawable.ic_baseline_share_active)
                    itemView.shareCountTv.setTextColor(Color.RED)
                }
            } else {
                itemView.shareCountTv.visibility = View.GONE
            }
        }
    }

    class PostEventViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(articleItem : PostEvent)  {
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(articleItem.image)
                .into(itemView.avatarIv)

            itemView.createdTv.text = Helper.timing(articleItem.createDate)
            itemView.authorTv.text = articleItem.authorName
            itemView.contentTv.text = articleItem.content

            if (articleItem.likeMe) {
                itemView.shareIv.setImageResource(R.drawable.ic_baseline_favorite_disabled)
                itemView.likeCountTv.setTextColor(Color.DKGRAY)
                articleItem.likeMe = false
                articleItem.likeCount --
                itemView.likeCountTv.text = articleItem.likeCount.toString()
                if (articleItem.likeCount < 1) {
                    itemView.likeCountTv.visibility = View.GONE
                }
            } else {
                itemView.likeIv.setImageResource(R.drawable.ic_baseline_favorite_active)
                itemView.likeCountTv.setTextColor(Color.RED)
                articleItem.likeCount ++
                if (!itemView.likeCountTv.isShown) {
                    itemView.likeCountTv.visibility = View.VISIBLE
                }
                itemView.likeCountTv.text = articleItem.likeCount.toString()
                articleItem.likeMe = true
            }

            if (articleItem.commentCount > 0) {
                itemView.commentCountTv.text = articleItem.commentCount.toString()
                if (articleItem.commentMe) {
                    itemView.commentIv.setImageResource(R.drawable.ic_baseline_mode_comment_active)
                    itemView.commentCountTv.setTextColor(Color.RED)
                }
            } else {
                itemView.commentCountTv.visibility = View.GONE
            }

            if (articleItem.shareCount > 0) {
                itemView.shareCountTv.text = articleItem.shareCount.toString()
                if (articleItem.shareMe) {
                    itemView.shareIv.setImageResource(R.drawable.ic_baseline_share_active)
                    itemView.shareCountTv.setTextColor(Color.RED)
                }
            } else {
                itemView.shareCountTv.visibility = View.GONE
            }
        }
    }


}