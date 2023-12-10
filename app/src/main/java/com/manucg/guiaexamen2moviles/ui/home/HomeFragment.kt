package com.manucg.guiaexamen2moviles.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.manucg.guiaexamen2moviles.R
import com.manucg.guiaexamen2moviles.databinding.FragmentHomeBinding
import com.manucg.guiaexamen2moviles.ui.operaciones.OperacionesViewModel

class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null

    private val viewModel : OperacionesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding!!.root

        binding!!.buttonNav.setOnClickListener {
            findNavController().navigate(R.id.nav_TabsFragment)
        }

        binding!!.textHome.text = viewModel.numero.toString()
        return root
    }

}