package com.manucg.guiaexamen2moviles.ui.Tabs

import androidx.lifecycle.ViewModel
import com.manucg.guiaexamen2moviles.modelo.BDEstaticaUsuarios
import com.manucg.guiaexamen2moviles.modelo.Usuario
import com.manucg.guiaexamen2moviles.ui.Tabs.usuarios.UsuariosRecyclerViewAdapter

class TabsViewModel : ViewModel() {
    var nombre : String = ""
    var edad : Int = 0

    val bd : BDEstaticaUsuarios = BDEstaticaUsuarios()

    var usuarioSeleccionado : Usuario = Usuario("",0)

    lateinit var recyclerViewAdapter : UsuariosRecyclerViewAdapter
}