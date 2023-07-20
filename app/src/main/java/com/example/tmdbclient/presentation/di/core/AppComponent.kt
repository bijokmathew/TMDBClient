package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.presentation.di.artist.ArtistSubComponet
import com.example.tmdbclient.presentation.di.core.AppModule
import com.example.tmdbclient.presentation.di.core.CacheDatabaseModule
import com.example.tmdbclient.presentation.di.core.DatabaseModule
import com.example.tmdbclient.presentation.di.core.LocalDataModule
import com.example.tmdbclient.presentation.di.core.NetModule
import com.example.tmdbclient.presentation.di.core.RemoteDataModule
import com.example.tmdbclient.presentation.di.core.RepositoryModule
import com.example.tmdbclient.presentation.di.core.UseCaseModule
import com.example.tmdbclient.presentation.di.movie.MovieSubComponent
import com.example.tmdbclient.presentation.di.tvshow.TvShowSubComponet
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        CacheDatabaseModule::class,
        DatabaseModule::class,
        LocalDataModule::class,
        NetModule::class,
        RemoteDataModule::class,
        RepositoryModule::class,
        UseCaseModule::class
    ]
)
interface AppComponent {

    fun artistSubComponent():ArtistSubComponet.Factory
    fun movieSubComponent():MovieSubComponent.Factory
    fun tvShowSubComponent():TvShowSubComponet.Factory

}