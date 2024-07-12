package com.example.android3homework2mc5.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android3homework2mc5.R
import com.example.android3homework2mc5.databinding.ItemPohotoBinding
import com.example.android3homework2mc5.models.Photo
import com.example.android3homework2mc5.utils.loadImage

class PhotosAdapter : ListAdapter<Photo, PhotosAdapter.PhotoViewHolder>(diffUtil) {

    inner class PhotoViewHolder(private val binding: ItemPohotoBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bind(photo: Photo) = with(binding){
                ivPhoto.contentDescription = root.context.getString(R.string.photo, photo.title)
                val imageUrl = "https://farm66.staticflickr.com/${photo.server}/${photo.id}_${photo.secret}.jpg"
                ivPhoto.loadImage(imageUrl)
                tvTitle.text = photo.title
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding =ItemPohotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    //это дифутил это сделан через обжект
    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<Photo>() {
            override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
                return oldItem == newItem
            }

        }
    }
}