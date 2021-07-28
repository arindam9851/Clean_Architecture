package com.example.viewpagerdemo.presentation.main.video

import com.example.viewpagerdemo.business.domain.VideoModel

sealed class VideoListStateEvent{
    object GetNetworkVideoListEvent: VideoListStateEvent()
    data class SaveToHistory(val data: List<VideoModel>) : VideoListStateEvent()

}
