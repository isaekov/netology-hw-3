package com.example.netology_hw_3.entity

import com.example.netology_hw_3.util.CoordinateLocation

class DataSource {
    companion object {
        fun createDataSet(): ArrayList<Post> {
            val list = ArrayList<Post>()

            list.add(
                Article(
                    authorName = "Pushkin",
                    createDate = "1534234234",
                    content = "content simple",
                    likeCount = 22,
                    commentCount = 12,
                    shareCount = 1,
                    likeMe = true,
                    commentMe = false,
                    shareMe = false,
                    image = "https://picsum.photos/200/300"
                )
            )

            list.add(
                Article(
                    authorName = "Pushkin",
                    createDate = "1534234234",
                    content = "content simple",
                    likeCount = 22,
                    commentCount = 12,
                    shareCount = 112,
                    likeMe = true,
                    commentMe = false,
                    shareMe = false,
                    image = "https://picsum.photos/200"
                )
            )

            list.add(
                Article(
                    authorName = "Pushkin",
                    createDate = "1534234234",
                    content = "content simple",
                    likeCount = 2,
                    commentCount = 0,
                    shareCount = 3423,
                    likeMe = false,
                    commentMe = false,
                    shareMe = false,
                    image = "https://picsum.photos/200"
                )
            )

            list.add(
                Article(
                    authorName = "Pushkin",
                    createDate = "1534234234",
                    content = "content simple",
                    likeCount = 222,
                    commentCount = 122,
                    shareCount = 100,
                    likeMe = true,
                    commentMe = true,
                    shareMe = false,
                    image = "https://picsum.photos/200"
                )
            )

            list.add(
                PostEvent(
                    authorName = "Pushkin",
                    createDate = "1534234234",
                    content = "content simple",
                    likeCount = 222,
                    commentCount = 122,
                    shareCount = 1,
                    likeMe = true,
                    commentMe = true,
                    shareMe = false,
                    coordinates = CoordinateLocation(latitude = "123124", longitude = "3421343"),
                    address = "asdklfj",
                    image = "https://picsum.photos/200"
                )
            )
            return list
        }
    }
}