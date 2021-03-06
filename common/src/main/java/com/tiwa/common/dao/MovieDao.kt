package com.tiwa.common.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tiwa.common.constant.Constants.MOVIE_TABLE
import com.tiwa.common.model.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movieList: List<Movie>?)

    @Query("DELETE FROM $MOVIE_TABLE ")
    suspend fun deleteAll()

    @Query("SELECT * FROM $MOVIE_TABLE")
    fun getAllMovies(): LiveData<List<Movie>>

    @Query("SELECT * FROM $MOVIE_TABLE WHERE id=:movieId ")
    fun getMovie(movieId:Int): LiveData<Movie>


}
