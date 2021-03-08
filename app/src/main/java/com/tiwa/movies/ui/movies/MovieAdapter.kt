package com.tiwa.movies.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.tiwa.movies.R
import com.tiwa.common.model.Movie


class MovieAdapter(private val movieList: List<Movie>,private val movieViewModel: MovieViewModel) : RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_movies, parent, false)
        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.bindItems(movie, movieViewModel)
    }
    override fun getItemCount(): Int {
        return movieList.size
    }

}