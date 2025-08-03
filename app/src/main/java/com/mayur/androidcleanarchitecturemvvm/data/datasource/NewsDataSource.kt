package com.mayur.androidcleanarchitecturemvvm.data.datasource

import com.mayur.androidcleanarchitecturemvvm.domain.model.NewsDataResponse
import com.mayur.androidcleanarchitecturemvvm.domain.model.SourcesResponse
import retrofit2.Response

interface NewsDataSource {
    suspend fun getTopHeadlines(country: String): Response<NewsDataResponse>
    suspend fun searchNews(query: String): Response<NewsDataResponse>
    suspend fun getSources(): Response<SourcesResponse>
}
