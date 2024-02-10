package com.practica.horoscapp.ui.home.horoscope

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.practica.horoscapp.databinding.FragmentHoroscopeBinding
import com.practica.horoscapp.domain.model.HoroscopeInfo
import com.practica.horoscapp.domain.model.HoroscopeInfo.*
import com.practica.horoscapp.domain.model.HoroscopeModel
import com.practica.horoscapp.ui.home.horoscope.adapter.HoroscopeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * Fragment: Vista reutilizable. Al crear un fragment blank, se recomienda limpiarlo y dejar los dos métodos que vienen por defecto.
 * El método principal es onCreateView... Se recomienda solo configurar este método
 * La anotación @AndroidEntryPoint permite que cada activity pueda inyectar y ser inyectada
 */
@AndroidEntryPoint
class HoroscopeFragment : Fragment() {
    /**
     * El binding de los fragment es diferente.
     * Cuando se tienen variables privadas, se les coloca el _ y cada que se quiera acceder a esta propiedad, se accede a su pseudo
     */
    private var _binding: FragmentHoroscopeBinding? = null
    private val binding get() = _binding!!

    /**
     * Esta variable conecta el fragment al viewModel
     */
    private val horoscopeViewModel by viewModels<HoroscopeViewModel>()
    private lateinit var horoscopeAdapter: HoroscopeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initUIState()
        initList()
    }

    private fun initList() {
        horoscopeAdapter = HoroscopeAdapter(onItemSelected = {
            val type = when (it) {
                Aquarius -> HoroscopeModel.Aquarius
                Aries -> HoroscopeModel.Aries
                Cancer -> HoroscopeModel.Cancer
                Capricorn -> HoroscopeModel.Capricorn
                Gemini -> HoroscopeModel.Gemini
                Leo -> HoroscopeModel.Leo
                Libra -> HoroscopeModel.Libra
                Pisces -> HoroscopeModel.Pisces
                Sagittarius -> HoroscopeModel.Sagittarius
                Scorpio -> HoroscopeModel.Scorpio
                Taurus -> HoroscopeModel.Taurus
                Virgo -> HoroscopeModel.Virgo
            }

            //Implementación del safeArg para la navegación segura
            findNavController().navigate(
                HoroscopeFragmentDirections.actionHoroscopeFragmentToHoroscopeDetailActivity(type)
            )
        })

        binding.rvHoroscope.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = horoscopeAdapter
        }
    }

    private fun initUIState() {
        /**
         * Esta corutina se engancha al ciclo de vida del fragment.
         * Se usa para fragmentos o activities
         * La siguiente co-rutina engancha al fragment con el view model y cada vez que se inicie el ciclo de vida, colecta los datos y podemos mostrarlos
         */

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeViewModel.horoscope.collect {
                    //Cuando entra acá, es por que hay cambios en horoscope
                    horoscopeAdapter.updateList(it)
                }
            }
        }
    }

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