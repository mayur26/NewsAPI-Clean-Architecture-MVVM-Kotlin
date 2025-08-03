package com.mayur.androidcleanarchitecturemvvm.domain.usecase

import com.mayur.androidcleanarchitecturemvvm.common.utils.ApiResult
import com.mayur.androidcleanarchitecturemvvm.domain.model.NewsDataResponse
import com.mayur.androidcleanarchitecturemvvm.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchTopHeadlinesUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    suspend fun getTopHeadlines(country: String = "us"): Flow<ApiResult<NewsDataResponse>> {
        return repository.fetchTopHeadlines(country)
    }
}

