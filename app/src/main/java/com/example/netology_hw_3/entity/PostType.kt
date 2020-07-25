package com.example.netology_hw_3.entity


const val REPOST = 0
const val POST = 1
const val EVENT_POST = 2
const val VIDEO_POST = 3
const val AD_POST = 4

enum class PostType {
    EVENT_POST, REPOST_POST, AD_POST, VIDEO_POST, POST
}