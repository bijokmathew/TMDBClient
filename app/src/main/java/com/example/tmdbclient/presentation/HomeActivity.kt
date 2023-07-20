package com.example.tmdbclient.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.tmdbclient.R
import com.example.tmdbclient.databinding.ActivityHomeBinding
import com.example.tmdbclient.presentation.artist.ArtistActivity
import com.example.tmdbclient.presentation.movie.MovieActivity
import com.example.tmdbclient.presentation.tvshow.TvShowActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =DataBindingUtil.setContentView(this,R.layout.activity_home)
        binding.btnMovies.setOnClickListener {
            val movieIntent = Intent(this,MovieActivity::class.java)
            startActivity(movieIntent)
        }
        binding.btnTvShows.setOnClickListener {
            val tvIntent = Intent(this,TvShowActivity::class.java)
            startActivity(tvIntent)
        }
        binding.btnArtists.setOnClickListener {
            val artistIntent = Intent(this,ArtistActivity::class.java)
            startActivity(artistIntent)
        }
    }
}