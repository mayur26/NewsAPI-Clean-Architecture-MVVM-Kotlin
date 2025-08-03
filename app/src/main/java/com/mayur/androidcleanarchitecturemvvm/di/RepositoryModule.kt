package com.mayur.androidcleanarchitecturemvvm.di

import com.mayur.androidcleanarchitecturemvvm.data.datasource.NewsDataSource
import com.mayur.androidcleanarchitecturemvvm.data.repositoryimpl.NewsRepositoryImpl
import com.mayur.androidcleanarchitecturemvvm.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideNewsRepository(dataSource: NewsDataSource): NewsRepository {
        return NewsRepositoryImpl(dataSource)
    }
}