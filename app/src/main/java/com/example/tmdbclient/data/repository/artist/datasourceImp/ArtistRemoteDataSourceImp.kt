package com.example.tmdbclient.data.repository.artist.datasourceImp

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.model.artist.ArtistList
import com.example.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImp(
    private val tmdbService: TMDBService,
    private val api_key:String
):ArtistRemoteDataSource {
    override suspend fun getPopularArtists(): Response<ArtistList> =tmdbService.getPopularArtists(api_key)
}