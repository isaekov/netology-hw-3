package com.example.netology_hw_3

import android.annotation.SuppressLint
import android.graphics.Color
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
            "1594421723", "Александр Сергеевич Пушкин", "Надев широкий боливар, " +
                    "Онегин едет на бульвар.",
            2, 100, 67, true, false, true
        )

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