package com.practica.horoscapp.ui.providers

import org.junit.Assert.assertNotNull
import org.junit.Test

class RandomCardProviderTest {
    @Test
    fun `getRandomCard should return a random card`() {
        //Given
        val randomCard = RandomCardProvider()

        //When
        val card = randomCard.getLucky()

        //Then
        /**
         * El assert es como un if. Tiene muchísimas opciones de uso
         */
        assertNotNull(card)
    }
}