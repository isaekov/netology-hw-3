package com.example.netology_hw_3.util

import android.annotation.SuppressLint
import com.example.netology_hw_3.entity.Post
import java.text.SimpleDateFormat
import java.util.*

class Helper {
    @SuppressLint("SimpleDateFormat")
    fun timing(post: Post): String {
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