package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.domain.repository.MovieRepository
import com.example.tmdbclient.domain.repository.PopularArtistRepository
import com.example.tmdbclient.domain.repository.TvShowRepository
import com.example.tmdbclient.domain.usecases.GetMoviewUseCase
import com.example.tmdbclient.domain.usecases.GetPopularArtistUsecase
import com.example.tmdbclient.domain.usecases.GetTvShowUseCase
import com.example.tmdbclient.domain.usecases.UpdateMovieUseCase
import com.example.tmdbclient.domain.usecases.UpdatePopularArtistUsecases
import com.example.tmdbclient.domain.usecases.UpdateTvShowUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun provideMovieUseCase(movieRepository: MovieRepository):GetMoviewUseCase {
        return GetMoviewUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository):UpdateMovieUseCase {
        return UpdateMovieUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideTvShowUseCase(tvShowRepository: TvShowRepository):GetTvShowUseCase {
        return GetTvShowUseCase(tvShowRepository)
    }
    @Singleton
    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository):UpdateTvShowUseCase {
        return UpdateTvShowUseCase(tvShowRepository)
    }

    @Singleton
    @Provides
    fun provideArtistUseCase(artistRepository: PopularArtistRepository):GetPopularArtistUsecase {
        return GetPopularArtistUsecase(artistRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateArtistUseCase(artistRepository: PopularArtistRepository):UpdatePopularArtistUsecases {
        return UpdatePopularArtistUsecases(artistRepository)
    }
}