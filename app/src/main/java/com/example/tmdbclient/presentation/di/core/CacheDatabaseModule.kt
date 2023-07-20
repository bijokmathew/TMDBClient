package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.tmdbclient.data.repository.artist.datasourceImp.ArtistCacheDataSourceImp
import com.example.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdbclient.data.repository.movie.datasourceImp.MovieCacheDataSourceImp
import com.example.tmdbclient.data.repository.tvShow.datasource.TvCacheDataSource
import com.example.tmdbclient.data.repository.tvShow.datasourceImp.TvCacheDataSourceImp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDatabaseModule {

    @Singleton
    @Provides
    fun provideCacheMovieResource():MovieCacheDataSource{
        return MovieCacheDataSourceImp()
    }

    @Singleton
    @Provides
    fun provideCacheTvShowResource():TvCacheDataSource{
        return TvCacheDataSourceImp()
    }

    @Singleton
    @Provides
    fun provideCacheArtistResource():ArtistCacheDataSource{
        return ArtistCacheDataSourceImp()
    }
}