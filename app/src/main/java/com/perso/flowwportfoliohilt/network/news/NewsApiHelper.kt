package com.perso.flowwportfoliohilt.network.news

import com.perso.flowwportfoliohilt.news.models.NewsModel
import retrofit2.Response

interface NewsApiHelper {
    suspend fun getHeadlines(): Response<NewsModel>

    suspend fun getGoogleNews(): Response<NewsModel>

    suspend fun getAppleNews(): Response<NewsModel>
}