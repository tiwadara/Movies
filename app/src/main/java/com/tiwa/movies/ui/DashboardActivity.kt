package com.tiwa.movies.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.tiwa.movies.R
import com.tiwa.movies.ui.movies.MovieViewModel
import com.tiwa.movies.ui.movies.MoviesListFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_dashboard.*

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {

    private val vehicleViewModel: MovieViewModel by  viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        toolbar.title = getString(R.string.title)
        toolbar.setLogo(R.mipmap.ic_launcher)
        toolbar.setTitleTextColor(ResourcesCompat.getColor(resources, R.color.colorWhite, null))
        loadFragment()
        observerViewModels()
    }

    private fun loadFragment() {
        val fragment: Fragment
        fragment = MoviesListFragment()
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_content, fragment)
        transaction.commit()
    }

    private fun observerViewModels() {
        vehicleViewModel.getIsLoading().observe(this, { isLoading ->
            if (isLoading) {
                toolbarprogress.visibility = View.VISIBLE
            } else {
                toolbarprogress.visibility = View.INVISIBLE
            }
        })
    }

}
