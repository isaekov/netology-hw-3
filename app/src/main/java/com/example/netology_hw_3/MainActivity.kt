package com.example.netology_hw_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.netology_hw_3.adatpter.PostAdapter
import com.example.netology_hw_3.entity.DataSource
import com.example.netology_hw_3.entity.Post
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var postAdapter:PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecycler()

    }

    private fun initRecycler() {
        recycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            postAdapter = PostAdapter(DataSource.createDataSet())
            adapter = postAdapter
        }
    }

}