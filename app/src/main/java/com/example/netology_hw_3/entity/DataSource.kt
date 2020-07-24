package com.example.netology_hw_3.entity

import com.example.netology_hw_3.util.CoordinateLocation

class DataSource {
    companion object {
        fun createDataSet(): ArrayList<Post> {
            val list = ArrayList<Post>()



            list.add(
                Post(
                    id = 1,
                    createDate = "1231231232",
                    authorName = "Pushkin",
                    content = "Text",
                    likeMe = true,
                    likeCount = 123,
                    commentCount = 2,
                    commentMe = false,
                    shareCount = 1,
                    shareMe = false,
                    image = "https://picsum.photos/200",
                    address = "Kazan",
                    coordinates = CoordinateLocation(latitude = "123124", longitude = "3421343"),
                    postType = PostType.POST
                )
            )

            list.add(
                Post(
                    id = 1,
                    createDate = "1231231232",
                    authorName = "Pushkin1",
                    content = "Text",
                    likeMe = true,
                    likeCount = 123,
                    commentCount = 2,
                    commentMe = false,
                    shareCount = 1,
                    shareMe = false,
                    image = "https://picsum.photos/200",
                    address = "Kazan",
                    coordinates = CoordinateLocation(latitude = "123124", longitude = "3421343"),
                    post = list[0],
                    postType = PostType.REPOST_POST
                )
            )

            list.add(
                Post(
                    id = 1,
                    createDate = "1231231232",
                    authorName = "Pushkin2",
                    content = "Text",
                    likeMe = true,
                    likeCount = 123,
                    commentCount = 2,
                    commentMe = false,
                    shareCount = 1,
                    shareMe = false,
                    image = "https://picsum.photos/200",
                    address = "Kazan",
                    coordinates = CoordinateLocation(latitude = "123124", longitude = "3421343")
                )
            )

            return list
        }
    }
}