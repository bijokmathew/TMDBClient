package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmdbclient.data.repository.artist.datasourceImp.ArtistRemoteDataSourceImp
import com.example.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdbclient.data.repository.movie.datasourceImp.MovieRemoteDataSourceImpl
import com.example.tmdbclient.data.repository.tvShow.datasource.TvRemoteDataSource
import com.example.tmdbclient.data.repository.tvShow.datasourceImp.TvRemoteDataSourceImp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val api_key:String) {

    @Singleton
    @Provides
    fun provideRemoteMovieDataSource(tmdbService: TMDBService):MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(
            tmdbService,api_key
        )

    }

    @Singleton
    @Provides
    fun provideRemoteTvShowDataSource(tmdbService: TMDBService):TvRemoteDataSource{
        return TvRemoteDataSourceImp(
            tmdbService,api_key
        )

    }

    @Singleton
    @Provides
    fun provideRemoteArtistDataSource(tmdbService: TMDBService):ArtistRemoteDataSource{
        return ArtistRemoteDataSourceImp(
            tmdbService,api_key
        )
    }
}