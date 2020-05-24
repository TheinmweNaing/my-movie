package com.naing.themovie.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.naing.themovie.R
import com.naing.themovie.model.dto.Movie

class MovieAdapter : ListAdapter<Movie, MovieAdapter.PopularViewHolder>(DIFF_CALLBACK) {

    interface AdapterItemClickListener {
        fun onClick(position: Int)
    }

    var adapterItemClickListener: AdapterItemClickListener? = null

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(
                oldItem: Movie,
                newItem: Movie
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: Movie,
                newItem: Movie
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val root = inflater.inflate(R.layout.layout_movie, parent, false)
        return PopularViewHolder(root)
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        getItem(position)
    }

    inner class PopularViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                adapterItemClickListener?.onClick(adapterPosition)
            }
        }
    }

    fun getItemAt(position: Int) = getItem(position)
}