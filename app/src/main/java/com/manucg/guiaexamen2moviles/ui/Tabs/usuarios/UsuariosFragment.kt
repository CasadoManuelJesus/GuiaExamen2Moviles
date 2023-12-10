package com.manucg.guiaexamen2moviles.ui.Tabs.usuarios

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.manucg.guiaexamen2moviles.OnInteractionListener
import com.manucg.guiaexamen2moviles.R
import com.manucg.guiaexamen2moviles.databinding.FragmentUsuariosListBinding
import com.manucg.guiaexamen2moviles.modelo.BDEstaticaUsuarios
import com.manucg.guiaexamen2moviles.modelo.Usuario
import com.manucg.guiaexamen2moviles.ui.Tabs.TabsViewModel

class UsuariosFragment : Fragment() {

    private var binding: FragmentUsuariosListBinding? = null
    private val viewModel : TabsViewModel by activityViewModels()

    private var mColumnCount = 1
    private lateinit var recyclerView: RecyclerView
    private lateinit var miAdapter : UsuariosRecyclerViewAdapter
    private lateinit var listaUsuarios: MutableList<Usuario>

    private var mListener: OnListFragmentInteractionListener? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentUsuariosListBinding.inflate(inflater, container, false)
        val root: View = binding!!.root

        listaUsuarios = viewModel.bd.getUsuarios()

        if (root is RecyclerView) {
            val context = root.context

            recyclerView = root
            recyclerView.layoutManager = if (mColumnCount <= 1) {
                LinearLayoutManager(context)
            } else {
                GridLayoutManager(context, mColumnCount)
            }

            miAdapter = UsuariosRecyclerViewAdapter(listaUsuarios, mListener)
            viewModel.recyclerViewAdapter = miAdapter
            recyclerView.adapter = miAdapter
        }

        return root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        // Paso 13: Verificar e inicializar el listener de interacción
        if (context is OnListFragmentInteractionListener) {
            mListener = context as OnListFragmentInteractionListener
        } else {
            throw RuntimeException(
                context.toString()
                        + " Se debe implementar OnListFragmentInteractionListener"
            )
        }
    }

    interface OnListFragmentInteractionListener {
        fun onListFragmentInteraction(item: Usuario?)
    }


}