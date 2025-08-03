package com.mayur.androidcleanarchitecturemvvm.data.repositoryimpl

import com.mayur.androidcleanarchitecturemvvm.common.utils.ApiResult
import com.mayur.androidcleanarchitecturemvvm.data.datasource.NewsDataSource
import com.mayur.androidcleanarchitecturemvvm.data.source.base.BaseApiResponse
import com.mayur.androidcleanarchitecturemvvm.domain.model.NewsDataResponse
import com.mayur.androidcleanarchitecturemvvm.domain.model.SourcesResponse
import com.mayur.androidcleanarchitecturemvvm.domain.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepositoryImpl @Inject constructor(
    private val dataSource: NewsDataSource
) : NewsRepository, BaseApiResponse() {

    override suspend fun fetchTopHeadlines(country: String): Flow<ApiResult<NewsDataResponse>> = flow {
        emit(ApiResult.Loading())

        val result = safeApiCall {
            dataSource.getTopHeadlines(country)
        }

        emit(result)
    }.flowOn(Dispatchers.IO)

    override suspend fun searchNews(query: String): Flow<ApiResult<NewsDataResponse>> = flow {
        emit(ApiResult.Loading())

        val result = safeApiCall {
            dataSource.searchNews(query)
        }

        emit(result)
    }.flowOn(Dispatchers.IO)

    override suspend fun fetchSources(): Flow<ApiResult<SourcesResponse>> = flow {
        emit(ApiResult.Loading())

        val result = safeApiCall {
            dataSource.getSources()
        }

        emit(result)
    }.flowOn(Dispatchers.IO)
}

