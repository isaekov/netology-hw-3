package com.example.netology_hw_3

import android.location.Location


data class Post(
    var createDate:String,
    var authorName:String,
    var content:String,
    var likeCount:Long,
    var commentCount:Long,
    var shareCount:Long,
    var likeMe:Boolean,
    var commentMe:Boolean,
    var shareMe:Boolean,
    var address: String,
    var coordinates: Pair<Double, Double>
)