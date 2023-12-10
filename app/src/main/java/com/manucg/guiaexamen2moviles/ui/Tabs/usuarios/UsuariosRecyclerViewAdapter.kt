package com.manucg.guiaexamen2moviles.ui.Tabs.usuarios

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.manucg.guiaexamen2moviles.R
import com.manucg.guiaexamen2moviles.databinding.FragmentUsuariosBinding
import com.manucg.guiaexamen2moviles.modelo.Usuario

class UsuariosRecyclerViewAdapter(
    private val usuarios: MutableList<Usuario>,  // Lista de elementos a mostrar en el RecyclerView
    private val mListener: UsuariosFragment.OnListFragmentInteractionListener?
) : RecyclerView.Adapter<UsuariosRecyclerViewAdapter.ViewHolder>() {

    // Paso 2: Implementar la función que devuelve la cantidad de elementos en la lista
    override fun getItemCount(): Int {
        return usuarios.size
    }

    // Paso 3: Definir la clase interna ViewHolder para representar cada elemento de la lista
    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        // Paso 4: Declarar los TextView
        val textoNombre: TextView = mView.findViewById(R.id.textNombreReg)
        val textoEdad: TextView = mView.findViewById(R.id.textEdad)

        // Paso 5: Declarar una variable para la vinculación de datos utilizando View Binding
        val binding: FragmentUsuariosBinding = FragmentUsuariosBinding.bind(mView)

        // Paso 6: Override del método toString para proporcionar una representación en cadena
        override fun toString(): String {
            return super.toString() + " '" + textoNombre.text + "'"
        }
    }

    // Paso 7: Inflar la vista del elemento de diseño y devolver un ViewHolder asociado
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflar la vista del elemento de diseño (layout) del RecyclerView
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_usuarios, parent, false)
        return ViewHolder(view)  // Devolver un ViewHolder asociado a la vista inflada
    }

    // Paso 8: Establecer el contenido de la vista en la posición dada
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Paso 9: Obtener el texto en la posición actual de la lista
        val usuario = usuarios[position]

        // Paso 10: Establecer el texto en la TextView del ViewHolder en la posición actual
        holder.textoNombre.text = usuario.nombre
        holder.textoEdad.text = usuario.edad.toString()

        holder.mView.setOnClickListener {
            mListener?.onListFragmentInteraction(usuario)
        }
    }
}