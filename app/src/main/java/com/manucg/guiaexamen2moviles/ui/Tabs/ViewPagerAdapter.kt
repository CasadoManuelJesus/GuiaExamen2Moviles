package com.manucg.guiaexamen2moviles.ui.Tabs

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.manucg.guiaexamen2moviles.ui.Tabs.RegistraUsuario.RegistraUsuarioFragment
import com.manucg.guiaexamen2moviles.ui.Tabs.usuarios.UsuariosFragment

class ViewPagerAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {

    //Lista de los fragements que vamos a utilizar
    val list: List<Fragment> = listOf(RegistraUsuarioFragment(), UsuariosFragment(), GestionaUsuarios())

    override fun getItemCount(): Int = list.size

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> RegistraUsuarioFragment()
            1 -> UsuariosFragment()
            2 -> GestionaUsuarios()
            else -> throw IllegalArgumentException("Invalid position")
        }
    }
}