package com.magicapp.youtubeapi.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.magicapp.youtubeapi.databinding.ItemYoutubeBinding
import com.magicapp.youtubeapi.models.Item
import com.squareup.picasso.Picasso

class YoutubeAdapter(val list: List<Item>, val onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<YoutubeAdapter.Vh>() {

    inner class Vh(var itemYoutubeBinding: ItemYoutubeBinding) :
        RecyclerView.ViewHolder(itemYoutubeBinding.root) {

        fun onBind(item: Item) {
            itemYoutubeBinding.apply {
                Picasso.get().load(item.snippet.thumbnails.high.url).into(image)
                tv.text = item.snippet.title
            }
            itemView.setOnClickListener {
                onItemClickListener.onItemClick(item.id.videoId)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemYoutubeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnItemClickListener {
        fun onItemClick(videoId: String)
    }
}