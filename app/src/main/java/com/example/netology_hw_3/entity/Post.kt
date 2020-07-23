package com.example.netology_hw_3.entity

import android.location.Location


interface Post {
    val createDate: String
    val authorName: String
    val content: String
    var likeCount: Long
    var commentCount: Long
    var shareCount: Long
    var likeMe: Boolean
    var commentMe: Boolean
    var shareMe: Boolean
    var image:String

    fun identifier() = this::class.java.name.hashCode()

}