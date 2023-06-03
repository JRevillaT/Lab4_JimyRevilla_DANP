package com.example.danp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.room.Room
import com.example.danp.data.AppDatabase
import com.example.danp.entities.Curso
import com.example.danp.entities.Estudiante
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "my-database").build()
        setContent {
            MainScreen()
        }
    }

    @Composable
    fun MainScreen() {
        Column {
            Button(onClick = { fillTables() }) {
                Text("Llenar tablas")
            }
        }
    }

    private fun fillTables() {
        GlobalScope.launch(Dispatchers.IO) {
            val cursoDao = database.cursoEstudianteDao()
            val estudianteDao = database.cursoEstudianteDao()

            val cursos = generateRandomCursos(5)
            val estudiantes = generateRandomEstudiantes(10)

            cursoDao.insertCursos(cursos)
            estudianteDao.insertEstudiantes(estudiantes)
        }
    }

    private fun generateRandomCursos(count: Int): List<Curso> {
        val cursos = mutableListOf<Curso>()
        for (i in 1..count) {
            val curso = Curso(i, "Curso $i")
            cursos.add(curso)
        }
        return cursos
    }

    private fun generateRandomEstudiantes(count: Int): List<Estudiante> {
        val estudiantes = mutableListOf<Estudiante>()
        val nombres = listOf("Juan", "María", "Pedro", "Ana", "Luis")
        val apellidos = listOf("Gómez", "Pérez", "Rodríguez", "López", "Martínez")
        for (i in 1..count) {
            val nombre = nombres.random()
            val apellido = apellidos.random()
            val estudiante = Estudiante(i, nombre, apellido)
            estudiantes.add(estudiante)
        }
        return estudiantes
    }
}