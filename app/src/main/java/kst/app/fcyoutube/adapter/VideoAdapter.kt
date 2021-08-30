package kst.app.fcyoutube.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kst.app.fcyoutube.R
import kst.app.fcyoutube.model.VideoModel

class VideoAdapter(val callback: (String,String) -> Unit):ListAdapter<VideoModel,VideoAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        fun bind(item:VideoModel){
            val titleTv = view.findViewById<TextView>(R.id.titleTv)
            val subTitleTv = view.findViewById<TextView>(R.id.subTitleTv)
            val thumbnailIv = view.findViewById<ImageView>(R.id.thumbnailIv)

            titleTv.text = item.title
            subTitleTv.text = item.subtitle

            Glide.with(thumbnailIv.context)
                .load(item.thumb)
                .into(thumbnailIv)

            view.setOnClickListener {
                callback(item.sources,item.title)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_video,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bind(currentList[position])
    }

    companion object{
        val diffUtil = object : DiffUtil.ItemCallback<VideoModel>() {
            override fun areItemsTheSame(oldItem: VideoModel, newItem: VideoModel): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: VideoModel, newItem: VideoModel): Boolean {
                return oldItem == newItem
            }

        }
    }

}