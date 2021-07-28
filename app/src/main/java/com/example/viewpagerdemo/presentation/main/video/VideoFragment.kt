package com.example.viewpagerdemo.presentation.main.video

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewpagerdemo.R
import com.example.viewpagerdemo.business.domain.VideoModel
import com.example.viewpagerdemo.presentation.BaseFragment
import com.example.viewpagerdemo.presentation.util.DataState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_video.*
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class VideoFragment : BaseFragment() {
    private val viewModel: VideoViewModel by viewModels()
    private lateinit var mAdapter: VideoAdapter
    private var mList = ArrayList<VideoModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_video, container, false)
    }

    companion object {
        fun create(): VideoFragment {
            return VideoFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUI()
        subscribeObserver()
        viewModel.setStateEvent(VideoListStateEvent.GetNetworkVideoListEvent)
    }

    private fun subscribeObserver() {
        viewModel.dataset.observe(viewLifecycleOwner, Observer {dataState->
            when(dataState){
                is DataState.Success<List<VideoModel>>->{
                    displayProgressBar(false)
                    setData(dataState.data)
                }
                is DataState.Error ->{
                    displayProgressBar(false)
                    displayError(dataState.exception.message)

                }
                is DataState.Loading->{
                    displayProgressBar(true)

                }
            }
        })

        viewModel.dataStateInsert.observe(viewLifecycleOwner, androidx.lifecycle.Observer { dataState ->
            when (dataState) {
                is DataState.Success<Long> -> {
                    Toast.makeText(mContext, "TITLE is now saved in database", Toast.LENGTH_SHORT).show()
                }
                is DataState.Error -> {
                    Toast.makeText(mContext, dataState.exception.message, Toast.LENGTH_SHORT).show()

                }
            }

        })
    }

    private fun setUpUI() {
        mAdapter = VideoAdapter(mList, mContext,this)
        video_recyclerview.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL,false)
            adapter = mAdapter
        }

    }
    private fun displayProgressBar(isDisplayed: Boolean){
        progress_bar.visibility = if(isDisplayed) View.VISIBLE else View.GONE
    }

    private fun displayError(message: String?){
        Toast.makeText(mContext,message, Toast.LENGTH_SHORT).show()
    }

    private fun setData(data: List<VideoModel>){
        mList.clear()
        mList.addAll(data)
        mAdapter.notifyDataSetChanged()

    }

    fun addToHistory(model: List<VideoModel>) {
        viewModel.setStateEvent(VideoListStateEvent.SaveToHistory(model))

    }
}