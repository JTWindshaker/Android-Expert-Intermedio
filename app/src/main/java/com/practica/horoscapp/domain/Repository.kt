package com.practica.horoscapp.domain

import com.practica.horoscapp.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediction(sign: String): PredictionModel?
}