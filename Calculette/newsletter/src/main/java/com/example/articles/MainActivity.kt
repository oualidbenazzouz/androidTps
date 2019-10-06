package com.example.articles

import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org")
            .addConverterFactory(GsonConverterFactory.create()) //ToJson
            .build() //setup

        val articleApi = retrofit.create(ArticleService::class.java)

        articleApi.fetchAllArticles().enqueue(object : Callback<Articles>{ //Fetch articles

            override fun onResponse(call: Call<Articles>, response: Response<Articles>) {
                showData(response.body()!!.articles)
            }
            override fun onFailure(call: Call<Articles>, t: Throwable) {
                d("title","onFail"+t)
            }
        })


    }
    private fun showData(articles: List<Article>) {

        recyclerView.apply {
            layoutManager= LinearLayoutManager(this@MainActivity)
            adapter = ArticlesAdapter(articles)
        }

    }


}
