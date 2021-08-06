package com.isidro.myapplication

data class materias(val id:Int, val nombre:String, val profe:String, val icono:ramas) {
    enum class ramas {
        MATEMATICAS,INGLES,PROGRAMACION
    }
}