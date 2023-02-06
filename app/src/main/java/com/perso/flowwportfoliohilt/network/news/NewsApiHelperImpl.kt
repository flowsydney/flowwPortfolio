package com.perso.flowwportfoliohilt.network.news

import com.perso.flowwportfoliohilt.news.models.NewsModel
import retrofit2.Response
import javax.inject.Inject

class NewsApiHelperImpl @Inject constructor(
    private val newsApiService: NewsApiService
) : NewsApiHelper {
    override suspend fun getArticles(): Response<NewsModel> = newsApiService.getArticles()
}