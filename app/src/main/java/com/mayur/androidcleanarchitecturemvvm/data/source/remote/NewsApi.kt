package com.mayur.androidcleanarchitecturemvvm.data.source.remote

import com.mayur.androidcleanarchitecturemvvm.common.utils.Constants
import com.mayur.androidcleanarchitecturemvvm.domain.model.NewsDataResponse
import com.mayur.androidcleanarchitecturemvvm.domain.model.SourcesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String = Constants.API_KEY
    ): Response<NewsDataResponse>

    @GET("everything")
    suspend fun searchNews(
        @Query("q") query: String,
        @Query("apiKey") apiKey: String = Constants.API_KEY,
        @Query("pageSize") pageSize: Int = 20
    ): Response<NewsDataResponse>

    @GET("sources")
    suspend fun getSources(
        @Query("apiKey") apiKey: String = Constants.API_KEY
    ): Response<SourcesResponse>
}
