package com.tiwa.common.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tiwa.common.constant.Constants

@Entity(tableName = Constants.MOVIE_TABLE)
data class Movie(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)