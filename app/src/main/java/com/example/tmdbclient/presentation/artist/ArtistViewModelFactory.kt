package com.example.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdbclient.domain.usecases.GetPopularArtistUsecase
import com.example.tmdbclient.domain.usecases.UpdatePopularArtistUsecases

class ArtistViewModelFactory(
    val updatePopularArtistUsecases: UpdatePopularArtistUsecases,
    val getPopularArtistUsecase: GetPopularArtistUsecase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewModel(getPopularArtistUsecase,updatePopularArtistUsecases) as T
    }
}