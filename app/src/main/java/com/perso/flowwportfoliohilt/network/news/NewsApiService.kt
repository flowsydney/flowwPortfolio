package com.perso.flowwportfoliohilt.network.news

import com.perso.flowwportfoliohilt.news.models.NewsModel
import com.perso.flowwportfoliohilt.util.Constants.API_KEY
import retrofit2.Response
import retrofit2.http.GET

interface NewsApiService {

    @GET("top-headlines?country=us&apiKey=$API_KEY")
    suspend fun getHeadlines(): Response<NewsModel>

    @GET("everything?q=android&from=2023-01-06&sortBy=publishedAt&apiKey=$API_KEY")
    suspend fun getGoogleNews(): Response<NewsModel>

    @GET("everything?q=apple&from=2023-01-06&sortBy=publishedAt&apiKey=$API_KEY")
    suspend fun getAppleNews(): Response<NewsModel>
}