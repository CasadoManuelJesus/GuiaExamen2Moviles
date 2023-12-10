package com.manucg.guiaexamen2moviles.modelo

data class Usuario(var nombre : String, var edad: Int){
    override fun toString(): String {
        return "Se llama $nombre y tiene $edad años"
    }
}
