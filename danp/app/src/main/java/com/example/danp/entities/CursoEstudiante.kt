package com.example.danp.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(entity = Curso::class, parentColumns = ["id"], childColumns = ["cursoId"]),
        ForeignKey(entity = Estudiante::class, parentColumns = ["id"], childColumns = ["estudianteId"])
    ]
)
data class CursoEstudiante(
    @PrimaryKey val id: Int,
    val cursoId: Int,
    val estudianteId: Int
)
