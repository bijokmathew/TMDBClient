package com.example.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.domain.usecases.GetPopularArtistUsecase
import com.example.tmdbclient.domain.usecases.UpdatePopularArtistUsecases

class ArtistViewModel(
    private val getPopularArtistUsecase: GetPopularArtistUsecase,
    private val updatePopularArtistUsecases: UpdatePopularArtistUsecases
) : ViewModel() {

    fun getArtists()= liveData {
        val artists= getPopularArtistUsecase.execute()
        emit(artists)
    }

    fun updateArtists()= liveData {
        val updatedArtists=updatePopularArtistUsecases.execute()
        emit(updatedArtists)
    }
}