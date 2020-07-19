package com.example.netology_hw_3

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.location.Location
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val post = Post(
            createDate = "1594421723",
            authorName = "Александр Сергеевич Пушкин",
            content = "Надев широкий боливар, Онегин едет на бульвар.",
            likeCount = 1,
            commentCount = 100,
            shareCount = 67,
            likeMe = true,
            commentMe = false,
            shareMe = true,
            address = "Hollywood",
            coordinates = Pair(55.753960, 37.620393)
        )

        location.setOnClickListener{
            val intent = Intent().apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse("geo:${post.coordinates.first},${post.coordinates.second}")            }
            startActivity(intent)
        }


        createdTv.text = timing(post)
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

    @SuppressLint("SimpleDateFormat")
    private fun timing(post:Post): String {
        val date = Date(post.createDate.toLong() * 1000L)
        val sdf = SimpleDateFormat("d MMMM yyyy")
        return when((System.currentTimeMillis()/1000) - post.createDate.toLong()) {
            in 1..30 -> "менее минуты назад"
            in 30..90 -> "минуту назад"
            in 90..120 -> "две минуты назад"
            in 120..180 -> "три минуты назад"
            in 180..300 -> "пять минут назад"
            in 300..600 -> "десять минут назад"
            in 600..1800 -> "тридцать минут назад"
            in 1800..3600 -> "час назад"
            else -> sdf.format(date).toString()
        }
    }

}