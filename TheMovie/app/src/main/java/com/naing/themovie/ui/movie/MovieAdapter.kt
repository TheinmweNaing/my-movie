package com.naing.themovie.ui.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.naing.themovie.BR
import com.naing.themovie.R
import com.naing.themovie.model.dto.Movie

class MovieAdapter : ListAdapter<Movie, MovieAdapter.MovieViewHolder>(
    DIFF_CALLBACK
) {

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            inflater,
            R.layout.layout_movie,
            parent,
            false
        )
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class MovieViewHolder(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                adapterItemClickListener?.onClick(adapterPosition)
            }
        }

        fun bind(movie: Movie) {
            binding.setVariable(BR.obj, movie)
            binding.executePendingBindings()
        }
    }

    fun getItemAt(position: Int) = getItem(position)
}