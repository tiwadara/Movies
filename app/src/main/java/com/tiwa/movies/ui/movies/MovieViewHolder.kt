package com.tiwa.movies.ui.movies

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tiwa.common.model.Movie
import kotlinx.android.synthetic.main.list_item_movies.view.*

open class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    fun bindItems(movie: Movie) {
        itemView.textViewFleetType.text = movie.title
        itemView.textViewVehicleLocation.text = movie.overview
        itemView.textViewPoiNumber.text = movie.id.toString()
    }

}