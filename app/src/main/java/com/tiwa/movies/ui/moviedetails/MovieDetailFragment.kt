package com.tiwa.movies.ui.moviedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.tiwa.common.model.Movie
import com.tiwa.movies.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_movie_detail.*

@AndroidEntryPoint
class MovieDetailFragment : Fragment() {

    private val modeViewModel: MovieDetailsViewModel by viewModels()
    private val arguments: MovieDetailFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observerViewModels()
    }

    private fun observerViewModels() {
        modeViewModel.getMovie(arguments.movieId).observe(viewLifecycleOwner, { movies ->
            if (movies != null) {
                populateView(movies)
            }
        })
    }

    private fun populateView(movie: Movie) {
        textViewMovieTitle.text = movie.title
        textViewOverview.text = movie.overview
    }
}
