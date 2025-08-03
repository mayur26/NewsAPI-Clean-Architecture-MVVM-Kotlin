package com.mayur.androidcleanarchitecturemvvm.domain.repository

import com.mayur.androidcleanarchitecturemvvm.common.utils.ApiResult
import com.mayur.androidcleanarchitecturemvvm.domain.model.NewsDataResponse
import com.mayur.androidcleanarchitecturemvvm.domain.model.SourcesResponse
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun fetchTopHeadlines(country: String): Flow<ApiResult<NewsDataResponse>>
    suspend fun searchNews(query: String): Flow<ApiResult<NewsDataResponse>>
    suspend fun fetchSources(): Flow<ApiResult<SourcesResponse>>
}
