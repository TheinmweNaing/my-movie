package com.naing.themovie.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.naing.themovie.R
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment() {

    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = MovieAdapter()
        adapter.adapterItemClickListener = object : MovieAdapter.AdapterItemClickListener {
            override fun onClick(position: Int) {
                val args = Bundle()
                adapter.getItemAt(position)?.id?.let {
                    args.putInt("ID", it)
                }
                findNavController().navigate(R.id.action_movieFragment_to_detailFragment, args)
            }

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "The Movie"

        recyclerView.apply {
            setHasFixedSize(true)
            addItemDecoration(DividerItemDecoration(view.context, DividerItemDecoration.VERTICAL))
            adapter = this@MovieFragment.adapter

        }
    }
}