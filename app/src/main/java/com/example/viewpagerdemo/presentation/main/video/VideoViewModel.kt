package com.example.viewpagerdemo.presentation.main.video

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viewpagerdemo.business.domain.VideoModel
import com.example.viewpagerdemo.business.interactor.MainRepository
import com.example.viewpagerdemo.presentation.util.DataState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class VideoViewModel
@ViewModelInject
constructor(
    private val mainRepository: MainRepository,
    ):ViewModel()
{

    private val _dataState: MutableLiveData<DataState<List<VideoModel>>> = MutableLiveData()
    private val _dataStateInsert: MutableLiveData<DataState<Long>> = MutableLiveData()

    val dataset: LiveData<DataState<List<VideoModel>>>
        get() = _dataState

    val dataStateInsert: LiveData<DataState<Long>>
        get() = _dataStateInsert
    fun setStateEvent(videoListStateEvent: VideoListStateEvent){
        viewModelScope.launch {
            when(videoListStateEvent){
                is VideoListStateEvent.GetNetworkVideoListEvent->{
                    mainRepository.getVideo()
                        .onEach { dataState ->
                            _dataState.value=dataState
                        }
                        .launchIn(viewModelScope)
                }
                is VideoListStateEvent.SaveToHistory -> {
                    mainRepository.insertHistory(videoListStateEvent.data)
                        .onEach { dataState ->
                            _dataStateInsert.value = dataState
                        }
                        .launchIn(viewModelScope)


                }
            }
        }
    }
}