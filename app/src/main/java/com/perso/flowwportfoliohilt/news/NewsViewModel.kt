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
    private val _res = MutableLiveData<Resource<NewsModel>>()

    val res : LiveData<Resource<NewsModel>>
        get() = _res

    init {
        getArticle()
    }

    private fun getArticle() = viewModelScope.launch {
        _res.postValue(Resource.loading(null))
        newsRepository.getArticles().let {
            if (it.isSuccessful) {
                _res.postValue(Resource.success(it.body()))
            } else {
                _res.postValue(Resource.error(it.errorBody().toString(), null))
            }
        }
    }
}