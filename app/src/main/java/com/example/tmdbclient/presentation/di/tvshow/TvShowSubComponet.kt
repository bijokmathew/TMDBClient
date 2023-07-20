package com.example.tmdbclient.presentation.di.tvshow

import com.example.tmdbclient.presentation.di.movie.MovieModule
import com.example.tmdbclient.presentation.tvshow.TvShowActivity
import dagger.Subcomponent

@Subcomponent(modules = [TvshowModule::class])
interface TvShowSubComponet {
    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():TvShowSubComponet
    }
}

