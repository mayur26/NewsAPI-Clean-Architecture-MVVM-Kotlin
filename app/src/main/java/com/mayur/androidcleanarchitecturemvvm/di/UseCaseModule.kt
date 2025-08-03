package com.mayur.androidcleanarchitecturemvvm.di

import com.mayur.androidcleanarchitecturemvvm.domain.repository.NewsRepository
import com.mayur.androidcleanarchitecturemvvm.domain.usecase.FetchTopHeadlinesUseCase
import com.mayur.androidcleanarchitecturemvvm.domain.usecase.SearchNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideFetchTopHeadlinesUseCase(repository: NewsRepository): FetchTopHeadlinesUseCase {
        return FetchTopHeadlinesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideSearchNewsUseCase(repository: NewsRepository): SearchNewsUseCase {
        return SearchNewsUseCase(repository)
    }
}
