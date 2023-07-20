package com.example.tmdbclient.data.repository.tvShow

import android.util.Log
import com.example.tmdbclient.data.model.tvshows.TvShow
import com.example.tmdbclient.data.model.tvshows.TvShowList
import com.example.tmdbclient.data.repository.tvShow.datasource.TvCacheDataSource
import com.example.tmdbclient.data.repository.tvShow.datasource.TvLocalDataSource
import com.example.tmdbclient.data.repository.tvShow.datasource.TvRemoteDataSource
import com.example.tmdbclient.domain.repository.TvShowRepository
import retrofit2.Response
import java.lang.Exception

class TvShowRepositoryImp(
    private val tvRemoteDataSource: TvRemoteDataSource,
    private val tvLocalDataSource: TvLocalDataSource,
    private val tvCacheDataSource: TvCacheDataSource
): TvShowRepository{
    override suspend fun getTvShows(): List<TvShow> = getTvShowsFromCache()


    override suspend fun updateTvShows(): List<TvShow> {
        val newTvShows = getTvShowsFromApi()
        tvLocalDataSource.deleteTvShows()
        tvLocalDataSource.saveTvShows(newTvShows)
        tvCacheDataSource.saveTvShowsToCache(newTvShows)
        return newTvShows
    }
    private suspend fun getTvShowsFromApi():List<TvShow>{
        lateinit var tvShowLists:List<TvShow>
        try {
            Log.i("MyTag  "," getTvShowsFromApi tvRemoteDataSource = ${tvRemoteDataSource}")
            val response = tvRemoteDataSource.getTvShows()
            Log.i("MyTag  "," getTvShowsFromApi response = ${response.toString()}")
            val body:TvShowList? = response.body()
            Log.i("MyTag  "," getTvShowsFromApi body = ${body}")
            if(body != null){
                tvShowLists = body.tvShows
            }
        } catch (e:Exception){
            Log.i("MyTag ","getTvShowsFromApi"+e.stackTrace.toString())
            Log.i("MyTag ","getTvShowsFromApi"+e.toString())
            Log.i("MyTag ","getTvShowsFromApi"+e.printStackTrace())
        }
        return tvShowLists
    }
    private suspend fun getTvShowsFromDB():List<TvShow>{
        lateinit var tvShowlists:List<TvShow>
        try {
            tvShowlists = tvLocalDataSource.getTvShows()
            if(tvShowlists.size>0) {
                return tvShowlists
            } else {
                tvShowlists = getTvShowsFromApi()
                tvLocalDataSource.saveTvShows(tvShowlists)
            }
        } catch (e:Exception){
            Log.i("MyTag getTvShowsFromDB",e.message.toString())
        }
        return tvShowlists
    }
    private suspend fun getTvShowsFromCache():List<TvShow>{
        lateinit var tvShowlists: List<TvShow>
        try{
            tvShowlists = tvCacheDataSource.getTvShows()
            if(tvShowlists.size>0){
                return tvShowlists
            } else {
                tvShowlists = getTvShowsFromDB()
                tvCacheDataSource.saveTvShowsToCache(tvShowlists)
            }
        } catch (e:Exception) {
            Log.i("MyTag getTvShowsFromDB",e.message.toString())
        }
        return tvShowlists
    }
}