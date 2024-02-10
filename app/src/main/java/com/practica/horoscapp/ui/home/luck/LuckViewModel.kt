package com.practica.horoscapp.ui.home.luck

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * La anotación @HiltViewModel permite que el viewModel pueda conectar a daggerHilt
 * La anotación @Inject sirve para inyectarle información a travez de un constructor. Permite inyectar datos, clases, etc etc
 */
@HiltViewModel
class LuckViewModel @Inject constructor() : ViewModel() {
}