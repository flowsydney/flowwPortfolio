package com.perso.flowwportfoliohilt.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.perso.flowwportfoliohilt.news.models.NewsModel
import com.perso.flowwportfoliohilt.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {
    private val _headlines = MutableLiveData<Resource<NewsModel>>()

    val headlinesFlow : LiveData<Resource<NewsModel>>
        get() = _headlines

    private val _googleNews = MutableLiveData<Resource<NewsModel>>()

    val googleNewsFlow : LiveData<Resource<NewsModel>>
        get() = _googleNews

    private val _appleNews = MutableLiveData<Resource<NewsModel>>()

    val appleNewsFlow : LiveData<Resource<NewsModel>>
        get() = _appleNews


    init {
        getHeadlinesArticle()
        getGoogleArticle()
        getAppleArticle()
    }
    private fun getHeadlinesArticle() = viewModelScope.launch {
        _headlines.postValue(Resource.loading(null))
        newsRepository.getHeadlines().let {
            if (it.isSuccessful) {
                _headlines.postValue(Resource.success(it.body()))
            } else {
                _headlines.postValue(Resource.error(it.errorBody().toString(), null))
            }
        }
    }

    private fun getGoogleArticle() = viewModelScope.launch {
        _googleNews.postValue(Resource.loading(null))
        newsRepository.getGoogleNews().let {
            if (it.isSuccessful) {
                _googleNews.postValue(Resource.success(it.body()))
            } else {
                _googleNews.postValue(Resource.error(it.errorBody().toString(), null))
            }
        }
    }

    private fun getAppleArticle() = viewModelScope.launch {
        _appleNews.postValue(Resource.loading(null))
        newsRepository.getAppleNews().let {
            if (it.isSuccessful) {
                _appleNews.postValue(Resource.success(it.body()))
            } else {
                _appleNews.postValue(Resource.error(it.errorBody().toString(), null))
            }
        }
    }
}