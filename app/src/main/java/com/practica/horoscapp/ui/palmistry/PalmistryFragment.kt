package com.practica.horoscapp.ui.palmistry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.practica.horoscapp.databinding.FragmentPalmistryBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Fragment: Vista reutilizable. Al crear un fragment blank, se recomienda limpiarlo y dejar los dos métodos que vienen por defecto.
 * El método principal es onCreateView... Se recomienda solo configurar este método
 * La anotación @AndroidEntryPoint permite que cada activity pueda inyectar y ser inyectada
 */
@AndroidEntryPoint
class PalmistryFragment : Fragment() {
    /**
     * El binding de los fragment es diferente.
     * Cuando se tienen variables privadas, se les coloca el _ y cada que se quiera acceder a esta propiedad, se accede a su pseudo
     */
    private var _binding: FragmentPalmistryBinding? = null
    private val binding get() = _binding!!

    /**
     * Este es el método que crea la vista
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPalmistryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}