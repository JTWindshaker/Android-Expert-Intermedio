package com.practica.horoscapp.ui.home.horoscope

import androidx.lifecycle.ViewModel
import com.practica.horoscapp.data.providers.HoroscopeProvider
import com.practica.horoscapp.domain.model.HoroscopeInfo
import com.practica.horoscapp.domain.model.HoroscopeInfo.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

/**
 * La anotación @HiltViewModel permite que el viewModel pueda conectar a daggerHilt
 * La anotación @Inject sirve para inyectarle información a travez de un constructor. Permite inyectar datos, clases, etc etc
 */
@HiltViewModel
class HoroscopeViewModel @Inject constructor(horoscopeProvider: HoroscopeProvider) :
    ViewModel() {

    /**
     * State Flow: Sirve para conectar y mandar notificaciones cuando hayan cambios.
     * Se crea una variable no privada para poder acceder a ella de forma segura
     */
    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())
    val horoscope: StateFlow<List<HoroscopeInfo>> = _horoscope

    //Este método se ejecuta cuando se cree el viewModel
    init {
        _horoscope.value = horoscopeProvider.getHoroscope()
    }
}