package com.example.danp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.danp.entities.Curso
import com.example.danp.entities.CursoWithEstudiantes
import com.example.danp.entities.Estudiante

@Dao
interface CursoEstudianteDao {
    @Insert
    suspend fun insertEstudiantes(estudiantes: List<Estudiante>)

    @Insert
    suspend fun insertCursos(cursos: List<Curso>)

    @Transaction
    @Query("SELECT * FROM Curso")
    suspend fun getCursosWithEstudiantes(): List<CursoWithEstudiantes>
}