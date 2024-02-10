package com.practica.horoscapp.data

import android.util.Log
import com.practica.horoscapp.data.network.HoroscopeApiService
import com.practica.horoscapp.domain.Repository
import com.practica.horoscapp.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) : Repository {
    override suspend fun getPrediction(sign: String): PredictionModel? {
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("Test", "Ha ocurrido un error ${it.message}") }

        return null
    }
}