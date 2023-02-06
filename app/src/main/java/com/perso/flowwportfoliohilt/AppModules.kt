package com.perso.flowwportfoliohilt

import com.perso.flowwportfoliohilt.network.news.NewsApiHelper
import com.perso.flowwportfoliohilt.network.news.NewsApiHelperImpl
import com.perso.flowwportfoliohilt.network.news.NewsApiService
import com.perso.flowwportfoliohilt.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModules {

    @Provides
    fun provideNewsBaseUrl() = Constants.BASE_NEWS_URL

    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
    } else {
        OkHttpClient.Builder().build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, baseUrl: String): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideNewsApiService(retrofit: Retrofit) = retrofit.create(NewsApiService::class.java)

    @Provides
    @Singleton
    fun provideNewsApiHelper(apiHelper: NewsApiHelperImpl): NewsApiHelper = apiHelper
}