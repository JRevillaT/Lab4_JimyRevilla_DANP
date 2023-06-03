package com.example.danp.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Curso(
    @PrimaryKey val id: Int,
    val nombre: String
)
