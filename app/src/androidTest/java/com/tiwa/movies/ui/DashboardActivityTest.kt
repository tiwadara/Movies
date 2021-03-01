package com.tiwa.movies.ui

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.tiwa.movies.R
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DashboardActivityTest {

    @Test
    fun checkView() {
//        onView(withId(R.id.toolbar)).perform(typeText("Steve"))
//        onView(withId(R.id.main_content)).perform(click())
//        onView(withText("My Movies")).check(matches(isDisplayed()))
    }

    @Test
    fun checkIfLoaderIsVisible() {

    }

}