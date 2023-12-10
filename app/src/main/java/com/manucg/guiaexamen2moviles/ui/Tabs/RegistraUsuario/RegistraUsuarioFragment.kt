package com.manucg.guiaexamen2moviles.ui.Tabs.RegistraUsuario

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.manucg.guiaexamen2moviles.databinding.FragmentRegistraUsuarioBinding
import com.manucg.guiaexamen2moviles.ui.Tabs.TabsViewModel

class RegistraUsuarioFragment : Fragment() {

    private val viewModel: TabsViewModel by activityViewModels()
    private var binding : FragmentRegistraUsuarioBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentRegistraUsuarioBinding.inflate(inflater, container, false)
        val root : View = binding!!.root

        return root
    }

}