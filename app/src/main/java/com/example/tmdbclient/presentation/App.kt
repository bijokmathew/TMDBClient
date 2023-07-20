package com.example.tmdbclient.presentation

import android.app.Application
import com.example.tmdbclient.BuildConfig
import com.example.tmdbclient.presentation.di.artist.ArtistSubComponet
import com.example.tmdbclient.presentation.di.core.AppComponent
import com.example.tmdbclient.presentation.di.core.AppModule
import com.example.tmdbclient.presentation.di.core.DaggerAppComponent
import com.example.tmdbclient.presentation.di.core.Injector
import com.example.tmdbclient.presentation.di.core.NetModule
import com.example.tmdbclient.presentation.di.core.RemoteDataModule
import com.example.tmdbclient.presentation.di.movie.MovieSubComponent
import com.example.tmdbclient.presentation.di.tvshow.TvShowSubComponet

class App:Application(),Injector {
    private lateinit var appComponet: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponet = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent = appComponet.movieSubComponent().create()


    override fun createTvShowSubComponent(): TvShowSubComponet = appComponet.tvShowSubComponent().create()

    override fun createArtistSubComponent(): ArtistSubComponet = appComponet.artistSubComponent().create()
}