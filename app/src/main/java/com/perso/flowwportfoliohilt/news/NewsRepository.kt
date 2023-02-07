package com.perso.flowwportfoliohilt.news

import com.perso.flowwportfoliohilt.network.news.NewsApiHelper
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsApiHelper: NewsApiHelper
){
    suspend fun getHeadlines() = newsApiHelper.getHeadlines()

    suspend fun getGoogleNews() = newsApiHelper.getGoogleNews()

    suspend fun getAppleNews() = newsApiHelper.getAppleNews()
}