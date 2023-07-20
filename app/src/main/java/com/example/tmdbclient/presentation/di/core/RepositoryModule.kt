package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.data.repository.artist.ArtistRepositoryImp
import com.example.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmdbclient.data.repository.movie.MovieRepositoryImp
import com.example.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdbclient.data.repository.tvShow.TvShowRepositoryImp
import com.example.tmdbclient.data.repository.tvShow.datasource.TvCacheDataSource
import com.example.tmdbclient.data.repository.tvShow.datasource.TvLocalDataSource
import com.example.tmdbclient.data.repository.tvShow.datasource.TvRemoteDataSource
import com.example.tmdbclient.domain.repository.MovieRepository
import com.example.tmdbclient.domain.repository.PopularArtistRepository
import com.example.tmdbclient.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository{
        return MovieRepositoryImp(movieRemoteDataSource,movieLocalDataSource,movieCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvRemoteDataSource: TvRemoteDataSource,
        tvLocalDataSource: TvLocalDataSource,
        tvCacheDataSource: TvCacheDataSource
    ): TvShowRepository{
        return TvShowRepositoryImp(tvRemoteDataSource,tvLocalDataSource,tvCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): PopularArtistRepository{
        return ArtistRepositoryImp(artistRemoteDataSource,artistLocalDataSource,artistCacheDataSource)
    }
}