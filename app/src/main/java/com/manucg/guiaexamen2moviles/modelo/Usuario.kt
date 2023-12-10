package com.manucg.guiaexamen2moviles.modelo

data class Usuario(var nombre : String, var edad: Int){
    override fun toString(): String {
        return "$nombre"
    }
}
