package com.practica.horoscapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * La anotación @HiltAndroidApp sirve para implementar el daggerhilt a la aplicación
 */
@HiltAndroidApp
class HoroscApp:Application()