package com.tiwa.common.typeconverter

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class GenreTypeConverterTest {

    private val  genreTypeConverter : GenreTypeConverter = GenreTypeConverter()
    private var genreIds : List<Int> = listOf()

    @Before
    fun setUp() {
        genreIds = listOf(1,3,4)
    }

    @Test
    fun genre_conversion() {
        val genreIdAsString = genreTypeConverter.fromGenre(genreIds)
        val convertedBankToGenreList = genreTypeConverter.toGenre(genreIdAsString)
        assertEquals(genreIds,convertedBankToGenreList)
    }
}