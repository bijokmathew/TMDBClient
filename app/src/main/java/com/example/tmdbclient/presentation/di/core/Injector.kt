package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.presentation.di.artist.ArtistSubComponet
import com.example.tmdbclient.presentation.di.movie.MovieSubComponent
import com.example.tmdbclient.presentation.di.tvshow.TvShowSubComponet

interface Injector {

    fun createMovieSubComponent():MovieSubComponent
    fun createTvShowSubComponent():TvShowSubComponet
    fun createArtistSubComponent():ArtistSubComponet
}