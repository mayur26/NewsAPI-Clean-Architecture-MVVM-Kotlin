package com.mayur.androidcleanarchitecturemvvm.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mayur.androidcleanarchitecturemvvm.common.utils.ApiResult
import com.mayur.androidcleanarchitecturemvvm.domain.model.ArticleData
import com.mayur.androidcleanarchitecturemvvm.domain.usecase.FetchTopHeadlinesUseCase
import com.mayur.androidcleanarchitecturemvvm.domain.usecase.SearchNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val fetchTopHeadlinesUseCase: FetchTopHeadlinesUseCase,
    private val searchNewsUseCase: SearchNewsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(NewsUiState())
    val uiState: StateFlow<NewsUiState> = _uiState.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    init {
        loadTopHeadlines()
    }

    fun loadTopHeadlines(country: String = "us") {
        viewModelScope.launch {
            fetchTopHeadlinesUseCase.getTopHeadlines(country).collect { result ->
                when (result) {
                    is ApiResult.Loading -> {
                        _uiState.value = _uiState.value.copy(isLoading = true, error = null)
                    }
                    is ApiResult.Success -> {
                        _uiState.value = _uiState.value.copy(
                            isLoading = false,
                            articles = result.data?.articles ?: emptyList(),
                            error = null
                        )
                    }
                    is ApiResult.Error -> {
                        _uiState.value = _uiState.value.copy(
                            isLoading = false,
                            error = result.message
                        )
                    }
                    is ApiResult.Nothing -> {
                        _uiState.value = _uiState.value.copy(isLoading = false)
                    }
                }
            }
        }
    }

    fun searchNews(query: String) {
        _searchQuery.value = query
        if (query.isBlank()) {
            loadTopHeadlines()
            return
        }

        viewModelScope.launch {
            searchNewsUseCase.searchNews(query).collect { result ->
                when (result) {
                    is ApiResult.Loading -> {
                        _uiState.value = _uiState.value.copy(isLoading = true, error = null)
                    }
                    is ApiResult.Success -> {
                        _uiState.value = _uiState.value.copy(
                            isLoading = false,
                            articles = result.data?.articles ?: emptyList(),
                            error = null
                        )
                    }
                    is ApiResult.Error -> {
                        _uiState.value = _uiState.value.copy(
                            isLoading = false,
                            error = result.message
                        )
                    }
                    is ApiResult.Nothing -> {
                        _uiState.value = _uiState.value.copy(isLoading = false)
                    }
                }
            }
        }
    }

    fun refresh() {
        if (_searchQuery.value.isBlank()) {
            loadTopHeadlines()
        } else {
            searchNews(_searchQuery.value)
        }
    }
}

data class NewsUiState(
    val isLoading: Boolean = false,
    val articles: List<ArticleData> = emptyList(),
    val error: String? = null
)

