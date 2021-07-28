package com.example.viewpagerdemo.presentation

import android.content.Context
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {
     lateinit var mContext: BaseActivity


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context as BaseActivity
    }


}