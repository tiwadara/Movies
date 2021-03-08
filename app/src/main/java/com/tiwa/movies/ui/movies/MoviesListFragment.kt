package com.tiwa.movies.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tiwa.common.model.Movie
import com.tiwa.movies.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_movie.*

@AndroidEntryPoint
class MoviesListFragment : Fragment() {

    private val viewModel: MovieViewModel by viewModels()
    private lateinit var adapter: MovieAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareViewElements()
        observerViewModels()
    }

    private fun prepareViewElements() {
        moviesRecyclerView.layoutManager = LinearLayoutManager(context)
        adapter = MovieAdapter(arrayListOf(), viewModel)
        moviesRecyclerView.adapter = adapter
    }

    private fun observerViewModels() {
        viewModel.getMovies().observe(viewLifecycleOwner, { movies ->
            if (movies != null) {
                populateView(movies)
            }
        })
        viewModel.movieItemClicked() .observe(viewLifecycleOwner, { movieId ->
            if (movieId != viewModel.initialMovieId) {
                navigate(movieId)
                viewModel.setItemClicked()
            }
        })
    }

    private fun navigate(movieId: Int) {
        val action = MoviesListFragmentDirections.actionMoviesListFragmentToMovieDetailFragment(movieId)
        view?.findNavController()?.navigate(action)

    }

    private fun populateView(movies: List<Movie>) {
        adapter = MovieAdapter(movies, viewModel)
        moviesRecyclerView.adapter = adapter
    }
}
