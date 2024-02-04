package com.practica.horoscapp.ui.home.horoscope

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.practica.horoscapp.databinding.FragmentHoroscopeBinding

/**
 * Fragment: Vista reutilizable. Al crear un fragment blank, se recomienda limpiarlo y dejar los dos métodos que vienen por defecto.
 * El método principal es onCreateView... Se recomienda solo configurar este método
 */
class HoroscopeFragment : Fragment() {
    /**
     * El binding de los fragment es diferente.
     * Cuando se tienen variables privadas, se les coloca el _ y cada que se quiera acceder a esta propiedad, se accede a su pseudo
     */
    private var _binding: FragmentHoroscopeBinding? = null
    private val binding get() = _binding!!

    /**
     * Este es el método que crea la vista
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHoroscopeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}