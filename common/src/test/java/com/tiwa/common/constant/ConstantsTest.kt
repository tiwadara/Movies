package com.tiwa.common.constant

import org.junit.Assert.*
import org.junit.Test

class ConstantsTest {
    @Test
    fun string_values_are_as_expected() {
        assertEquals( "Couldn't reach the server. Check your internet connection", Constants.NO_INTERNET_ERROR)
        assertEquals("An unknown error occurred", Constants.ERROR_MESSAGE)
        assertEquals("https://api.themoviedb.org/3/", Constants.BASE_URL)
        assertEquals("c25570abe255f13ed098959f70e6acaf", Constants.API_KEY)
        assertEquals("movie_table", Constants.MOVIE_TABLE)
        assertEquals("movie_database.db", Constants.DATABASE_NAME)
    }
}