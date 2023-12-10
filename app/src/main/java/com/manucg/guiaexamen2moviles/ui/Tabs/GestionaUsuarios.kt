package com.manucg.guiaexamen2moviles.ui.Tabs

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SpinnerAdapter
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.activityViewModels
import com.manucg.guiaexamen2moviles.OnInteractionListener
import com.manucg.guiaexamen2moviles.R
import com.manucg.guiaexamen2moviles.databinding.DialogDeleteBinding
import com.manucg.guiaexamen2moviles.databinding.DialogUpdateBinding
import com.manucg.guiaexamen2moviles.databinding.FragmentGestionaUsuariosBinding
import com.manucg.guiaexamen2moviles.modelo.Usuario
import com.manucg.guiaexamen2moviles.ui.Tabs.usuarios.UsuariosFragment


class GestionaUsuarios : Fragment() {

    private var binding : FragmentGestionaUsuariosBinding ?= null
    private val viewModel : TabsViewModel by activityViewModels()
    lateinit var spinnerAdapter: ArrayAdapter<Usuario>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGestionaUsuariosBinding.inflate(inflater, container, false)
        val root : View = binding!!.root

        spinnerAdapter = ArrayAdapter(this.requireContext(), android.R.layout.simple_spinner_item, viewModel.bd.getUsuarios())
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding!!.spinner.adapter = spinnerAdapter

        binding!!.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selected = binding!!.spinner.getItemAtPosition(position) as Usuario
                viewModel.usuarioSeleccionado = selected

                binding!!.editTextUpdateNombre.setText(selected.nombre)
                binding!!.editTextUpdateEdad.setText(selected.edad.toString())
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }

        binding!!.checkNombre.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                binding!!.editTextUpdateNombre.isEnabled = isChecked
            } else {
                binding!!.editTextUpdateNombre.isEnabled = isChecked
            }
        }

        binding!!.checkEdad.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                binding!!.editTextUpdateEdad.isEnabled = isChecked
            } else {
                binding!!.editTextUpdateEdad.isEnabled = isChecked
            }
        }

        binding!!.buttonDelete.setOnClickListener {
            verDialogoBorrado()
        }

        binding!!.buttonUpdate.setOnClickListener {
            verDialogoUpdate(this.binding!!)
        }

        return root
    }

    private fun verDialogoUpdate(bindingGestion: FragmentGestionaUsuariosBinding) {
        val inflater = getLayoutInflater()

        var binding : DialogUpdateBinding = DialogUpdateBinding.inflate(inflater)
        val view=binding.root
        binding.textNombreAntes.text = viewModel.usuarioSeleccionado.nombre
        binding.textEdadAntes.text = viewModel.usuarioSeleccionado.edad.toString()
        var nuevoNombre : String
        var nuevaEdad : Int
        if (bindingGestion.checkNombre.isChecked){
            nuevoNombre = bindingGestion.editTextUpdateNombre.text.toString()
            binding.textNombreDespues.text = nuevoNombre
        } else {
            nuevoNombre = viewModel.usuarioSeleccionado.nombre
            binding.textNombreDespues.text = nuevoNombre
        }

        if (bindingGestion.checkEdad.isChecked){
            nuevaEdad = bindingGestion.editTextUpdateEdad.text.toString().toInt()
            binding.textEdadDespues.text = nuevaEdad.toString()
        } else {
            nuevaEdad = viewModel.usuarioSeleccionado.edad
            binding.textEdadDespues.text = nuevaEdad.toString()
        }

        val builder = AlertDialog.Builder(this.requireContext())
            .setView(view)
            .setTitle("Actualizar usuario")
            .setPositiveButton("Enviar") { dialog, id ->
                run {
                    viewModel.bd.updateUsuario(viewModel.usuarioSeleccionado, Usuario(nuevoNombre, nuevaEdad))
                    spinnerAdapter.notifyDataSetChanged()
                    viewModel.recyclerViewAdapter.notifyDataSetChanged()
                }
            }
            .setNegativeButton("Cancelar") { dialog, id -> }
            .show()

    }

    private fun verDialogoBorrado() {

        val inflater = getLayoutInflater()

        var binding : DialogDeleteBinding = DialogDeleteBinding.inflate(inflater)
        val view=binding.root
        Log.d("en el alertidialog", viewModel.usuarioSeleccionado.nombre)
        binding.textAlertNombre.text = viewModel.usuarioSeleccionado.nombre
        Log.d("texto del alert", binding.textAlertNombre.text.toString())
        val builder = AlertDialog.Builder(this.requireContext())

            .setView(view)
            .setTitle("Borrar usuario")
            .setPositiveButton("Enviar") { dialog, id ->
                run {
                    when (binding.radioDelete.checkedRadioButtonId) {
                        R.id.radioSi -> {
                            viewModel.bd.deleteUsuario(viewModel.usuarioSeleccionado)
                            spinnerAdapter.notifyDataSetChanged()
                            viewModel.recyclerViewAdapter.notifyDataSetChanged()
                        }
                        else -> {
                        }
                    }
                }
            }
            .setNegativeButton("Cancelar") { dialog, id -> }
            .show()

    }

}