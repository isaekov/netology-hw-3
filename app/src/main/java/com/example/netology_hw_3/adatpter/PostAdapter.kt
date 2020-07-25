package com.example.netology_hw_3.adatpter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.netology_hw_3.R
import com.example.netology_hw_3.entity.*
import com.example.netology_hw_3.view.*
import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo


class PostAdapter : RecyclerView.Adapter<ViewHolder>() {

    internal val bag = CompositeDisposable()
    internal var items = BehaviorRelay.createDefault(arrayListOf<Post>())

    init {
        items.observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                /*for (post in it) {
                    Log.d(
                        "dddaaa",
                        "Object $post, id = ${post.id}, postType = ${post.postType}, source = ${post.source}"
                    )
                }*/
                notifyDataSetChanged()
            }.addTo(bag)
    }


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

    override fun getItemId(position: Int) = items.value[position].id


    override fun getItemCount() = items.value.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder as BaseViewHolder) {
            bind(items.value[position])
        }
    }

    override fun getItemViewType(position: Int) = when (items.value[position].postType) {
            PostType.POST -> POST
            PostType.REPOST_POST -> REPOST
            PostType.AD_POST -> AD_POST
            PostType.EVENT_POST -> EVENT_POST
            PostType.VIDEO_POST -> VIDEO_POST
    }


}