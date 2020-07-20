package com.example.netology_hw_3

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.netology_hw_3.entity.Article
import com.example.netology_hw_3.entity.Post
import com.example.netology_hw_3.entity.PostEvent
import com.example.netology_hw_3.util.CoordinateLocation
import com.example.netology_hw_3.util.Helper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val helper = Helper()
    private lateinit var post: Post

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val postEvent = PostEvent(
            createDate = "1594421723",
            authorName = "Александр Сергеевич Пушкин",
            content = "Надев широкий боливар, Онегин едет на бульвар.",
            likeCount = 1,
            commentCount = 100,
            shareCount = 67,
            likeMe = true,
            commentMe = false,
            shareMe = true,
            address = "Казань",
            coordinates = CoordinateLocation(latitude = "55.798551", longitude =  "49.106324")
        )

        val article = Article(
            createDate = "1594421723",
            authorName = "Александр Сергеевич Пушкин",
            content = "Надев широкий боливар, Онегин едет на бульвар.",
            likeCount = 1,
            commentCount = 100,
            shareCount = 67,
            likeMe = true,
            commentMe = false,
            shareMe = true
        )

        post = article

        initPost()
        showMap(post)
    }


    private fun initPost() {
        createdTv.text = helper.timing(post)
        authorTv.text = post.authorName
        contentTv.text = post.content
        if (post.likeCount > 0) {
            likeCountTv.text = post.likeCount.toString()
            if (post.likeMe) {
                likeIv.setImageResource(R.drawable.ic_baseline_favorite_active)
                likeCountTv.setTextColor(Color.RED)
            }
        } else {
            likeCountTv.visibility = View.GONE
        }

        likeIv.setOnClickListener {
            if (post.likeMe) {
                likeIv.setImageResource(R.drawable.ic_baseline_favorite_disabled)
                likeCountTv.setTextColor(Color.DKGRAY)
                post.likeMe = false
                post.likeCount --
                likeCountTv.text = post.likeCount.toString()
                if (post.likeCount < 1) {
                    likeCountTv.visibility = View.GONE
                }
            } else {
                likeIv.setImageResource(R.drawable.ic_baseline_favorite_active)
                likeCountTv.setTextColor(Color.RED)
                post.likeCount ++
                if (!likeCountTv.isShown) {
                    likeCountTv.visibility = View.VISIBLE
                }
                likeCountTv.text = post.likeCount.toString()
                post.likeMe = true

            }
        }

        if (post.commentCount > 0) {
            commentCountTv.text = post.commentCount.toString()
            if (post.commentMe) {
                commentIv.setImageResource(R.drawable.ic_baseline_mode_comment_active)
                commentCountTv.setTextColor(Color.RED)
            }
        } else {
            commentCountTv.visibility = View.GONE
        }

        if (post.shareCount > 0) {
            shareCountTv.text = post.shareCount.toString()
            if (post.shareMe) {
                shareIv.setImageResource(R.drawable.ic_baseline_share_active)
                shareCountTv.setTextColor(Color.RED)
            }
        } else {
            shareCountTv.visibility = View.GONE
        }

    }

    private fun showMap(post: Post) {
        if (post is PostEvent) {
            location.visibility = View.VISIBLE
            location.setOnClickListener {
                val intent = Intent().apply {
                    action = Intent.ACTION_VIEW
                    data =
                        Uri.parse("geo:${post.coordinates.latitude},${post.coordinates.longitude}")
                }
                startActivity(intent)
            }
        }
    }



}