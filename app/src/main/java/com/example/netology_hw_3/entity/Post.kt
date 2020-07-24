package com.example.netology_hw_3.entity

import com.example.netology_hw_3.util.CoordinateLocation

data class Post(
     val id: Long,
     val createDate: String,
     val authorName: String,
     val content: String,
     var likeCount: Long,
     var likeMe: Boolean,
     var commentCount: Long,
     var commentMe: Boolean,
     var shareCount: Long,
     var shareMe: Boolean,
     var image: String,
     var postType: PostType = PostType.EVENT_POST,
     val address: String? = null,
     val coordinates: CoordinateLocation? = null,
     var post: Post? = null,
     var repostMe:Boolean = false,
     var adSourceImage: String? = null,
     val adHead:String? = null,
     val adImageContent: String? = null,
     val videoUrl: String? = null

)