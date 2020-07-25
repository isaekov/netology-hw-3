package com.example.netology_hw_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.netology_hw_3.adatpter.PostAdapter
import com.example.netology_hw_3.entity.Post
import com.example.netology_hw_3.network.Connect
import io.ktor.client.request.get
import io.ktor.util.KtorExperimentalAPI
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity(), CoroutineScope by MainScope() {

    private lateinit var postAdapter:PostAdapter
    private val url = "https://raw.githubusercontent.com/isaekov/netology-hw-6-object-to-json/master/post.json"


    @KtorExperimentalAPI
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        launch {
            val post = withContext(Dispatchers.IO) {
                Connect.http.get<ArrayList<Post>>(url)
            }
            initRecycler(post)
        }
    }

    private fun initRecycler(post: ArrayList<Post>) {
        postAdapter = PostAdapter()
        with(recycler) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = postAdapter
            (adapter as PostAdapter).items.accept(post)
            progress_post.visibility = View.GONE
        }
    }

}