package com.example.viewpagerdemo.business.interactor

import com.example.viewpagerdemo.business.datasource.cache.AppDao
import com.example.viewpagerdemo.business.datasource.cache.history.HistoryCacheEntity
import com.example.viewpagerdemo.business.datasource.cache.history.HistoryCacheMapper
import com.example.viewpagerdemo.business.datasource.network.ApiServices
import com.example.viewpagerdemo.business.datasource.network.videoresponses.VideoResponseMapper
import com.example.viewpagerdemo.business.domain.VideoModel
import com.example.viewpagerdemo.presentation.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class MainRepository
constructor(
    private val appDao: AppDao,
    private val apiServices: ApiServices,
    private val videoResponseMapper: VideoResponseMapper,
    private val historyCacheMapper: HistoryCacheMapper
)

{


    suspend fun getVideo(): Flow<DataState<List<VideoModel>>> = flow {
        emit(DataState.Loading)
        try {
            val networkResponse= apiServices.getVideoList("Michael+jackson","musicVideo")
            val videoData= videoResponseMapper.mapFromEntityList(networkResponse.results)

            emit(DataState.Success(videoData))
        }
        catch (e: Exception){
            emit(DataState.Error(e))
        }
    }

    suspend fun insertHistory(historyData: List<VideoModel>): Flow<DataState<Long>> = flow {
        emit(DataState.Loading)
        try {
            var inserted: Long = 0L
            for ( data in historyData ){
                inserted= appDao.insert(historyCacheMapper.mapToEntity(data))
            }
            emit(DataState.Success(inserted))
        }
        catch (e: Exception) {
            emit(DataState.Error(e))
        }

    }

    suspend fun getHistoryData(): Flow<DataState<List<HistoryCacheEntity>>> = flow {
        emit(DataState.Loading)
        try {
            val cachedData= appDao.getHistory()
            emit(DataState.Success(cachedData))
        }catch (e:Exception){
            emit(DataState.Error(e))

        }
    }


}