package com.perso.flowwportfoliohilt.news.models

data class NewsModel(
    val status: String,
    val totalResult: Int,
    val articles: List<Articles>
)