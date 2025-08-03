package com.mayur.androidcleanarchitecturemvvm.di

import android.app.Application
import android.content.Context
import com.mayur.androidcleanarchitecturemvvm.data.repositoryimpl.NewsRepositoryImpl
import com.mayur.androidcleanarchitecturemvvm.domain.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideContext(application: Application): Context = application.applicationContext
}