package com.practica.horoscapp.domain.usecase

import com.practica.horoscapp.domain.Repository
import javax.inject.Inject

class GetPrediction @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(sign: String) = repository.getPrediction(sign)
}