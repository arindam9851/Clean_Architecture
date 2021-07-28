package com.example.viewpagerdemo.presentation.util

import com.example.viewpagerdemo.R
import com.example.viewpagerdemo.presentation.main.history.HistoryFragment
import com.example.viewpagerdemo.presentation.main.video.VideoFragment

interface ResourceStore {

    companion object {
        val tabList = listOf(
            R.string.video, R.string.history
        )
        val pagerFragments = listOf(
            VideoFragment.create(), HistoryFragment.create())
    }
}