package com.practica.horoscapp.ui.palmistry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.PermissionChecker
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
    companion object {
        private const val CAMERA_PERMISSION = android.Manifest.permission.CAMERA
    }

    /**
     * El binding de los fragment es diferente.
     * Cuando se tienen variables privadas, se les coloca el _ y cada que se quiera acceder a esta propiedad, se accede a su pseudo
     */
    private var _binding: FragmentPalmistryBinding? = null
    private val binding get() = _binding!!
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {

        } else {
            Toast.makeText(
                requireContext(),
                "Acepta los permisos para poder disfrutar de una experiencia mágica",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (checkCameraPermission()) {
            //Tiene
        } else {
            requestPermissionLauncher.launch(CAMERA_PERMISSION)
        }
    }

    private fun checkCameraPermission(): Boolean {
        return PermissionChecker.checkSelfPermission(
            requireContext(),
            CAMERA_PERMISSION
        ) == PermissionChecker.PERMISSION_GRANTED
    }

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