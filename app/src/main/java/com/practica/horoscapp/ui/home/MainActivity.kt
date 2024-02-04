package com.practica.horoscapp.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.practica.horoscapp.R
import com.practica.horoscapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    /**
     * Se inicializa el binding de la vista.
     * lateinit: variable que se iniciará más tarde
     */
    private lateinit var binding: ActivityMainBinding

    /**
     * Se crea un controlador que se encargará de gestionar los pasos entre fragmentos (Mirar método initNavitation).
     */
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * Se configura el binding
         */
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        initNavigation()
    }

    /**
     * Configura y establece un controlador para el navBotton de la activity
     */
    private fun initNavigation() {
        val navHost: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHost.navController
        binding.bottomNavView.setupWithNavController(navController)
    }
}