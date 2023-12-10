package com.manucg.guiaexamen2moviles.ui.operaciones

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.manucg.guiaexamen2moviles.OnInteractionListener
import com.manucg.guiaexamen2moviles.R
import com.manucg.guiaexamen2moviles.databinding.FragmentOperacionesBinding

class OperacionesFragment : Fragment() {

    private var binding: FragmentOperacionesBinding? = null

    private val viewModel : OperacionesViewModel by activityViewModels()

    lateinit var listener: OnInteractionListener

    lateinit var text : TextView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentOperacionesBinding.inflate(inflater, container, false)
        val root: View = binding!!.root

        val text : TextView = binding!!.textNumero
        text.text = viewModel.numero.toString()

        binding!!.buttonIncremento.setOnClickListener {
            viewModel.numero += 1
            listener.onAction(binding!!.buttonIncremento)
            text.text = viewModel.numero.toString()
        }
        return root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as OnInteractionListener
        } catch (e: ClassCastException ) {
            throw ClassCastException(context.toString()
                    + " Se debe implementar OnActionListener")
        }
    }

}