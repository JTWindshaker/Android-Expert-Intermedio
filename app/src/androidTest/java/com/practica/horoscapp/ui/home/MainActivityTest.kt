package com.practica.horoscapp.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.practica.horoscapp.R
import com.practica.horoscapp.ui.detail.HoroscopeDetailActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class MainActivityTest {
    /**
     * Esto es para que la clase pueda ser injectada
     */
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    var mainActivityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        hiltRule.inject()
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun when_mainactivity_is_created_then_open_luck_fragment() {
        onView(withId(R.id.luckFragment)).perform(click())
    }

    /**
     * IMPORTANTE: Para que los test de UI funcionen, toca ir a Dibujo y desactivar todas las animaciones del móvil (Ir a opciones de desarrollador).
     */
    @Test
    fun when_horoscope_is_selected_then_open_detail() {
        onView(withId(R.id.rvHoroscope)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0, click()
            )
        )

        intended(IntentMatchers.hasComponent(HoroscopeDetailActivity::class.java.name))
    }
}