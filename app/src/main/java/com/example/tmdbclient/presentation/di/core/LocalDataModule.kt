package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.data.db.ArtistDao
import com.example.tmdbclient.data.db.MovieDao
import com.example.tmdbclient.data.db.TVShowDao
import com.example.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmdbclient.data.repository.artist.datasourceImp.ArtistLocalDataSourceImp
import com.example.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdbclient.data.repository.movie.datasourceImp.MovieLocalDataSourceImp
import com.example.tmdbclient.data.repository.tvShow.datasource.TvLocalDataSource
import com.example.tmdbclient.data.repository.tvShow.datasourceImp.TvLocalDataSourceImp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideLocalMovieDataSource(movieDao: MovieDao):MovieLocalDataSource {
        return MovieLocalDataSourceImp(movieDao)
    }

    @Singleton
    @Provides
    fun provideLocalTvShowDataSource(tvShowDao: TVShowDao):TvLocalDataSource {
        return TvLocalDataSourceImp(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideLocalArtistDataSource(artistDao: ArtistDao):ArtistLocalDataSource {
        return ArtistLocalDataSourceImp(artistDao)
    }
}