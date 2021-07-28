package com.example.viewpagerdemo.presentation.main.history

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viewpagerdemo.business.datasource.cache.history.HistoryCacheEntity
import com.example.viewpagerdemo.business.domain.VideoModel
import com.example.viewpagerdemo.business.interactor.MainRepository
import com.example.viewpagerdemo.presentation.main.video.VideoListStateEvent
import com.example.viewpagerdemo.presentation.util.DataState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi

class HistoryViewModel
@ViewModelInject
constructor(
    private val mainRepository: MainRepository
):ViewModel()
{

    private val _dataState: MutableLiveData<DataState<List<HistoryCacheEntity>>> = MutableLiveData()
    val dataset: LiveData<DataState<List<HistoryCacheEntity>>>
        get() = _dataState

    fun setStateEvent(historyStateEvent: HistoryStateEvent){
        viewModelScope.launch {
            when(historyStateEvent){
                is HistoryStateEvent.GetHistoryListEvent->{
                    mainRepository.getHistoryData()
                        .onEach { dataState ->
                            _dataState.value=dataState
                        }
                        .launchIn(viewModelScope)
                }

            }
        }
    }
}