package com.tiwa.common.model

import org.junit.Assert.*
import org.junit.Test

class DatesTest{
    @Test
    fun testMinimum() {
        val dates = Dates()
        val datesCopy = dates.copy(minimum = "1")
        assertEquals("1", datesCopy.minimum)
    }
    @Test
    fun testMaximum() {
        val dates = Dates()
        val datesCopy = dates.copy(maximum = "100")
        assertEquals("100", datesCopy.maximum)
    }
}