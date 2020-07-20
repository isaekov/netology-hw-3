package com.example.netology_hw_3.entity

import com.example.netology_hw_3.util.CoordinateLocation

data class PostEvent(
    override val createDate: String,
    override val authorName: String,
    override val content: String,
    override var likeCount: Long,
    override var commentCount: Long,
    override var shareCount: Long,
    override var likeMe: Boolean,
    override var commentMe: Boolean,
    override var shareMe: Boolean,
    val address: String,
    val coordinates: CoordinateLocation
) : Post