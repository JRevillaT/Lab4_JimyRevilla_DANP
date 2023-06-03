package com.example.danp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.danp.entities.Curso
import com.example.danp.entities.CursoEstudiante
import com.example.danp.entities.Estudiante

@Database(entities = [Curso::class, Estudiante::class, CursoEstudiante::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cursoEstudianteDao(): CursoEstudianteDao
}