package com.example.netology_hw_3

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.netology_hw_3.adatpter.PostAdapter
import com.example.netology_hw_3.entity.Article
import com.example.netology_hw_3.entity.DataSource
import com.example.netology_hw_3.entity.Post
import com.example.netology_hw_3.entity.PostEvent
import com.example.netology_hw_3.util.CoordinateLocation
import com.example.netology_hw_3.util.Helper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var postAdapter:PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecycler()
        add()

    }

    private fun initRecycler() {
        recycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            postAdapter = PostAdapter()
            adapter = postAdapter
        }
    }

    private fun add() {
        val data = DataSource.createDataSet()
        postAdapter.submit(data)
    }
}