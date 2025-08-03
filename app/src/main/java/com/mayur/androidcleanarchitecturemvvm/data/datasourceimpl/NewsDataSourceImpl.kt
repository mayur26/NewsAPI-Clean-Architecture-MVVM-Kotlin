package com.mayur.androidcleanarchitecturemvvm.data.datasourceimpl

import com.mayur.androidcleanarchitecturemvvm.data.datasource.NewsDataSource
import com.mayur.androidcleanarchitecturemvvm.data.source.remote.NewsApi
import com.mayur.androidcleanarchitecturemvvm.domain.model.NewsDataResponse
import com.mayur.androidcleanarchitecturemvvm.domain.model.SourcesResponse
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsDataSourceImpl @Inject constructor(
    private val api: NewsApi
) : NewsDataSource {

    override suspend fun getTopHeadlines(country: String): Response<NewsDataResponse> {
        return api.getTopHeadlines(country)
    }

    override suspend fun searchNews(query: String): Response<NewsDataResponse> {
        return api.searchNews(query)
    }

    override suspend fun getSources(): Response<SourcesResponse> {
        return api.getSources()
    }
}
