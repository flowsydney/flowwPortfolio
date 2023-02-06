package com.perso.flowwportfoliohilt.network.news

import com.perso.flowwportfoliohilt.news.models.NewsModel
import com.perso.flowwportfoliohilt.util.Constants.API_KEY
import retrofit2.Response
import retrofit2.http.GET

interface NewsApiService {

    @GET("top-headlines?country=us&apiKey=$API_KEY")
    suspend fun getArticles(): Response<NewsModel>
}