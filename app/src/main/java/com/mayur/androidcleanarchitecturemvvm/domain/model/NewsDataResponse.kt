package com.mayur.androidcleanarchitecturemvvm.domain.model
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class NewsDataResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticleData>
)

data class SourcesResponse(
    val status: String,
    val sources: List<SourceData>
)

@Parcelize
data class ArticleData(
    val source: SourceData,
    val author: String?,
    val title: String,
    val description: String?,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String?
) : Parcelable

@Parcelize
data class SourceData(
    val id: String?,
    val name: String
): Parcelable
