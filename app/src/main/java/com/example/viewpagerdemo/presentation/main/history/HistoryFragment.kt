package com.example.viewpagerdemo.presentation.main.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewpagerdemo.R
import com.example.viewpagerdemo.business.datasource.cache.history.HistoryCacheEntity
import com.example.viewpagerdemo.business.domain.VideoModel
import com.example.viewpagerdemo.presentation.BaseFragment
import com.example.viewpagerdemo.presentation.main.video.VideoAdapter
import com.example.viewpagerdemo.presentation.main.video.VideoListStateEvent
import com.example.viewpagerdemo.presentation.util.DataState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_history.*
import kotlinx.android.synthetic.main.fragment_video.*
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
@AndroidEntryPoint
class HistoryFragment : BaseFragment() {
    private val viewModel:HistoryViewModel by viewModels()
    private lateinit var mAdapter: HistoryAdapter
    private var mList = ArrayList<HistoryCacheEntity>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    companion object {
        fun create(): HistoryFragment {
            return HistoryFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUI()
        subscribeObserver()

    }

    private fun setUpUI() {
        mAdapter = HistoryAdapter(mList, mContext,this)
        history_recyclerview.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL,false)
            adapter = mAdapter
        }


    }
    override fun onResume() {
        super.onResume()
        viewModel.setStateEvent(HistoryStateEvent.GetHistoryListEvent)
    }
    private fun subscribeObserver() {
        viewModel.dataset.observe(viewLifecycleOwner, Observer {dataState->
            when(dataState){
                is DataState.Success<List<HistoryCacheEntity>>->{
                    setData(dataState.data)
                }
                is DataState.Error ->{
                    displayError(dataState.exception.message)

                }
                is DataState.Loading->{

                }
            }
        })
    }

    private fun setData(data: List<HistoryCacheEntity>) {
        if (data.isNotEmpty())
        {
            mList.clear()
            mList.addAll(data)
            mAdapter.notifyDataSetChanged()
        }
    }

    private fun displayError(message: String?) {
        Toast.makeText(mContext,message, Toast.LENGTH_SHORT).show()

    }
}