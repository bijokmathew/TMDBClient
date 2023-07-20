package com.example.tmdbclient.data.repository.artist

import android.util.Log
import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmdbclient.domain.repository.PopularArtistRepository
import java.lang.Exception

class ArtistRepositoryImp(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
):PopularArtistRepository {
    override suspend fun getPopularArtist(): List<Artist>  = getArtistFromCache()


    override suspend fun updatePopularArtist(): List<Artist> {
        val newArtistList = getArtistDataFromApi()
        artistLocalDataSource.deleteArtists()
        artistLocalDataSource.savePopularArtists(newArtistList)
        artistCacheDataSource.savePopularArtists(newArtistList)
        return newArtistList
    }

    private suspend fun getArtistDataFromApi():List<Artist>{
        lateinit var artistList: List<Artist>
        try{
            val response = artistRemoteDataSource.getPopularArtists()
            val body = response.body()
            if(body!=null){
                artistList = body.artists
            }
        }catch (e:Exception){
            Log.i("MyTag",e.message.toString())
        }
        return artistList
    }
    private suspend fun getArtistFromDB():List<Artist>{
        lateinit var arristList:List<Artist>
        try{
            arristList = artistLocalDataSource.getPopularArtists()
            if(arristList.size>0){
                return arristList
            } else {
                arristList = getArtistDataFromApi()
                artistLocalDataSource.savePopularArtists(arristList)
            }
        }catch (e:Exception){
            Log.i("MyTag", e.message.toString())
        }
        return arristList
    }
    private suspend fun getArtistFromCache():List<Artist>{
        lateinit var aristList:List<Artist>
        try {
            aristList= artistCacheDataSource.getPopularArtists()
            if(aristList.size>0){
                return aristList
            } else {
                aristList = getArtistFromDB()
                artistLocalDataSource.savePopularArtists(aristList)
            }
        }catch (e:Exception){
            Log.i("MyTag",e.message.toString())
        }
        return aristList
    }
}