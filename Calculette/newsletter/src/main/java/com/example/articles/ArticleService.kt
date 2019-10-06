package com.example.articles

import retrofit2.Call
import retrofit2.http.GET

interface ArticleService {

    @GET("/v2/everything?q=bitcoin&from=2019-09-06&sortBy=publishedAt&apiKey=f900040118e343e6975d263f86a85913")
    fun fetchAllArticles(): Call<Articles>


}