package com.example.netology_hw_3.entity

data class Article(
    override val createDate: String,
    override val authorName: String,
    override val content: String,
    override var likeCount: Long,
    override var commentCount: Long,
    override var shareCount: Long,
    override var likeMe: Boolean,
    override var commentMe: Boolean,
    override var shareMe: Boolean
): Post