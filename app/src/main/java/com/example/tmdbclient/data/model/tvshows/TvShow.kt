package com.example.tmdbclient.data.model.tvshows


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "popular_tvShow")
data class TvShow(


    @SerializedName("first_air_date")
    val firstAirDate: String?,

    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String?,
    @SerializedName("overview")
    val popularity: Double?,
    @SerializedName("poster_path")
    val posterPath: String?,

)