package com.manucg.guiaexamen2moviles.ui.detalle_usuario

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.manucg.guiaexamen2moviles.R
import com.manucg.guiaexamen2moviles.databinding.ContentMainBinding
import com.manucg.guiaexamen2moviles.databinding.FragmentDetalleUsuarioBinding
import com.manucg.guiaexamen2moviles.ui.Tabs.TabsViewModel

class DetalleUsuario : Fragment() {

    private val viewModel: TabsViewModel by activityViewModels()
    private var binding : FragmentDetalleUsuarioBinding ?=  null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetalleUsuarioBinding.inflate(inflater, container, false)
        val root : View = binding!!.root
        val textNombre = binding!!.detalleNombre
        textNombre.text = viewModel.nombre
        val textEdad = binding!!.detalleEdad
        textEdad.text = viewModel.edad.toString()
        return root
    }


}