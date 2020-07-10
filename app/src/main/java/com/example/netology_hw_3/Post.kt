package com.example.netology_hw_3


data class Post(
    val createDate:String,
    val authorName:String,
    val content:String,
    val likeCount:Long,
    val commentCount:Long,
    val shareCount:Long,
    var likeMe:Boolean,
    var commentMe:Boolean,
    var shareMe:Boolean
)