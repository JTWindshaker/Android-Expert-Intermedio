package com.practica.horoscapp.data.network.response

import com.practica.horoscapp.motherobject.HoroscopeMotherObject.anyResponse
import io.kotlintest.shouldBe
import org.junit.Test

class PredictionResponseTest {

    @Test
    fun `toDomain Should Return A Correct PredictionModel`() {
        //Given
        //val horoscopeResponse = anyResponse.copy(sign = "libra") ESTO ES PARA EDITAR UN MODEL OBJECT POR DEFECTO
        val horoscopeResponse = anyResponse.copy(sign = "libra")

        //When
        val predictionModel = horoscopeResponse.toDomain()

        //Then
        predictionModel.sign shouldBe horoscopeResponse.sign
        predictionModel.horoscope shouldBe horoscopeResponse.horoscope
    }
}