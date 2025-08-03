package com.mayur.androidcleanarchitecturemvvm.domain.usecase

import com.mayur.androidcleanarchitecturemvvm.common.utils.ApiResult
import com.mayur.androidcleanarchitecturemvvm.domain.model.NewsDataResponse
import com.mayur.androidcleanarchitecturemvvm.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchNewsUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    suspend fun searchNews(query: String): Flow<ApiResult<NewsDataResponse>> {
        return repository.searchNews(query)
    }
}
