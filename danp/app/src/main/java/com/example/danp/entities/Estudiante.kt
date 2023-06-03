package com.example.danp.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Estudiante(
    @PrimaryKey val id: Int,
    val nombres: String,
    val apellidos: String
) {
    val nombreCompleto: String
        get() = "$nombres $apellidos"
}
