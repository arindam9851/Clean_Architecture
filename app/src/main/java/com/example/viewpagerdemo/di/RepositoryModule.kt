package com.example.viewpagerdemo.di

import com.example.viewpagerdemo.business.datasource.cache.AppDao
import com.example.viewpagerdemo.business.datasource.cache.history.HistoryCacheMapper
import com.example.viewpagerdemo.business.datasource.network.ApiServices
import com.example.viewpagerdemo.business.datasource.network.videoresponses.VideoResponseMapper
import com.example.viewpagerdemo.business.interactor.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideMainRepository(
        appDao: AppDao,
        apiServices: ApiServices,
        videoResponseMapper: VideoResponseMapper,
        historyCacheMapper: HistoryCacheMapper

    ): MainRepository {
        return MainRepository(appDao,apiServices,videoResponseMapper,historyCacheMapper)
    }
}