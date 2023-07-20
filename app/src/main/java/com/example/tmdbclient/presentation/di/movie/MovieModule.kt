package com.example.tmdbclient.presentation.di.movie

import com.example.tmdbclient.domain.usecases.GetMoviewUseCase
import com.example.tmdbclient.domain.usecases.UpdateMovieUseCase
import com.example.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviewUseCase: GetMoviewUseCase,
        updateMovieUseCase: UpdateMovieUseCase
    ):MovieViewModelFactory {
        return MovieViewModelFactory(getMoviewUseCase,updateMovieUseCase)
    }
}