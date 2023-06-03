package com.example.danp.entities

import androidx.room.Embedded
import androidx.room.Relation


data class CursoWithEstudiantes(
    @Embedded val curso: Curso,
    @Relation(
        parentColumn = "id",
        entityColumn = "cursoId"
    )
    val estudiantes: List<Estudiante>
)