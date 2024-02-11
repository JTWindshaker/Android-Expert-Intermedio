package com.practica.horoscapp.ui.horoscope

import com.practica.horoscapp.data.providers.HoroscopeProvider
import com.practica.horoscapp.motherobject.HoroscopeMotherObject
import com.practica.horoscapp.motherobject.HoroscopeMotherObject.horoscopeInfoList
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class HoroscopeViewModelTest {
    /**
     * Se usa (relaxed=true) debajo en la anotación si queremos ignorar las funciones que requieran de otras cosas. NO ES RECOMENDABLE
     */
    @MockK
    lateinit var horoscopeProvider: HoroscopeProvider

    private lateinit var viewModel: HoroscopeViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `When viewModel is created then horoscopes are loaded`() {
        /**
         * Si la función usa corutinas, se usa coEvery
         */
        //coEvery { horoscopeProvider.getHoroscope() } returns listOf()

        every { horoscopeProvider.getHoroscope() } returns horoscopeInfoList
        //Given
        viewModel = HoroscopeViewModel(horoscopeProvider)

        //When
        val horoscopes = viewModel.horoscope.value

        //Then
        assertTrue(horoscopes.isNotEmpty())
    }
}