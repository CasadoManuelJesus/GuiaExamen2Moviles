package com.manucg.guiaexamen2moviles.modelo

class BDEstaticaUsuarios() {
    private var usuarios: MutableList<Usuario> =
        mutableListOf(
            Usuario("Pedro", 13),
            Usuario("Adolfo", 15),
            Usuario("Dioni", 10),
            Usuario("María José", 18),
            Usuario("Carmen", 18),
            Usuario("Victoria", 16)
        )

    fun getUsuarios(): MutableList<Usuario> {
        return usuarios
    }

    fun addUsuario(usuario: Usuario) {
        usuarios.add(usuario)
    }

    fun deleteUsuario(usuario: Usuario) {
        usuarios.remove(usuario)
    }
}