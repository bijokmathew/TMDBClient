package com.example.tmdbclient.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbclient.R
import com.example.tmdbclient.databinding.ActivityMovieBinding
import com.example.tmdbclient.presentation.di.core.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var binding: ActivityMovieBinding
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var adaptor: MovieAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_movie)
        (application as Injector).createMovieSubComponent().inject(this)
        movieViewModel = ViewModelProvider(this,factory)[MovieViewModel::class.java]
        initRecyclerView()
    }

    fun initRecyclerView(){
        binding.movieRecyclerViewe.layoutManager = LinearLayoutManager(this)
        adaptor = MovieAdaptor()
        binding.movieRecyclerViewe.adapter = adaptor
        displayMovies()
    }

    fun displayMovies(){
        binding.progressBar.visibility = View.VISIBLE
        val result = movieViewModel.getMovies().observe(
            this,
            Observer {
                if(it !=null){
                    adaptor.setList(it)
                    adaptor.notifyDataSetChanged()
                    binding.progressBar.visibility = View.GONE
                } else {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this,"Sorry No data found !!", Toast.LENGTH_LONG).show()
                }
            }
        )
    }

}