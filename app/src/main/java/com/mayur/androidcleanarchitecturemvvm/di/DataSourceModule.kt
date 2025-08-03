package com.mayur.androidcleanarchitecturemvvm.di

import com.mayur.androidcleanarchitecturemvvm.data.datasource.NewsDataSource
import com.mayur.androidcleanarchitecturemvvm.data.datasourceimpl.NewsDataSourceImpl
import com.mayur.androidcleanarchitecturemvvm.data.source.remote.NewsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideNewsDataSource(api: NewsApi): NewsDataSource {
        return NewsDataSourceImpl(api)
    }
}
