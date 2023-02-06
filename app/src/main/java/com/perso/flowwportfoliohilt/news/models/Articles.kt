package com.perso.flowwportfoliohilt.news.models

data class Articles(
    val source: Source,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String
)
