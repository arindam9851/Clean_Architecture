package com.example.viewpagerdemo.presentation.main.video

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.viewpagerdemo.R
import com.example.viewpagerdemo.business.domain.VideoModel
import com.example.viewpagerdemo.presentation.BaseActivity
import com.example.viewpagerdemo.presentation.BaseFragment
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class VideoAdapter(private val list: List<VideoModel>, private val mContext: BaseActivity,private val mFragment: BaseFragment) : RecyclerView.Adapter<VideoAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem: View = layoutInflater.inflate(R.layout.row, parent, false)
        return ViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model: VideoModel =list[position]
        holder.tvName.text=model.trackName
        holder.tvArtistName.text=model.artistName
        Glide
            .with(mContext)
            .load(model.thumbnail)
            .placeholder(R.drawable.ic_launcher_foreground)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .into(holder.imgPoster)

        holder.parent.setOnClickListener(View.OnClickListener {
            ((mFragment as VideoFragment).addToHistory(listOf(model)))
        })

    }

    override fun getItemCount(): Int {
        return list.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPoster=itemView.findViewById(R.id.poster_image)as AppCompatImageView
        val tvName=itemView.findViewById(R.id.text_name)as AppCompatTextView
        val tvArtistName=itemView.findViewById(R.id.txt_artistname)as AppCompatTextView
        val parent=itemView.findViewById(R.id.parent)as ConstraintLayout




    }
}