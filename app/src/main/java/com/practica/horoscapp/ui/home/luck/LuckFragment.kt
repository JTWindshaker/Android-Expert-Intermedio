package com.practica.horoscapp.ui.home.luck

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import androidx.core.animation.doOnEnd
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.practica.horoscapp.R
import com.practica.horoscapp.databinding.FragmentLuckBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.Random

/**
 * Fragment: Vista reutilizable. Al crear un fragment blank, se recomienda limpiarlo y dejar los dos métodos que vienen por defecto.
 * El método principal es onCreateView... Se recomienda solo configurar este método
 * La anotación @AndroidEntryPoint permite que cada activity pueda inyectar y ser inyectada
 */
@AndroidEntryPoint
class LuckFragment : Fragment() {
    /**
     * El binding de los fragment es diferente.
     * Cuando se tienen variables privadas, se les coloca el _ y cada que se quiera acceder a esta propiedad, se accede a su pseudo
     */
    private var _binding: FragmentLuckBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initListener()
    }

    private fun initListener() {
        binding.ivRoulette.setOnClickListener {
            spinRoulette()
        }
    }

    private fun spinRoulette() {
        val random = Random()
        val degress = random.nextInt(1440) + 360

        val animator =
            ObjectAnimator.ofFloat(binding.ivRoulette, View.ROTATION, 0f, degress.toFloat())
        animator.duration = 2000
        animator.interpolator = DecelerateInterpolator()
        animator.doOnEnd { slideCard() }
        animator.start()
    }

    private fun slideCard() {
        val slideUpAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.slide_up)
        slideUpAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                binding.ivReverse.isVisible = true
            }

            override fun onAnimationEnd(animation: Animation?) {
                growCard()
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })

        binding.ivReverse.startAnimation(slideUpAnimation)
    }

    private fun growCard() {
        val growAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.grow)
        growAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                binding.ivReverse.isVisible = false
                showPremonitionView()
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })

        binding.ivReverse.startAnimation(growAnimation)
    }

    private fun showPremonitionView() {
        val disappearAnimation = AlphaAnimation(1.0f, 0.0f)
        disappearAnimation.duration = 200

        val appearAnimation = AlphaAnimation(0.0f, 1.0f)
        appearAnimation.duration = 1000

        disappearAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                binding.preview.isVisible = false
                binding.prediction.isVisible = true
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })

        binding.preview.startAnimation(disappearAnimation)
        binding.prediction.startAnimation(appearAnimation)
    }

    /**
     * Este es el método que crea la vista
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLuckBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}