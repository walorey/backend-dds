package com.example.demo.service;

import java.util.Date;
import java.util.List;

import com.example.demo.entity.Alumno;
import com.example.demo.entity.Curso;

public interface CursoService {

    // Método para obtener todos los cursos
    List<Curso> getAll();

    // Método para guardar un curso
    Curso crearCurso(Curso curso);
    
 // Método para actualizar
    Curso updateCurso(Curso curso); 
    
 //Metodo para borrar
    void deleteCurso(Long id);
    
    //Obtener curso por ID
    Curso getCursoById(Long id);
    
    // Método para obtener cursos que finalizan en una fecha específica
    List<Curso> findCursosByFechaFin(Date fechaFin);
    
    //Metodo para obtener cursos vigentes
    List<Curso> getCursosVigentesByDocenteId(Long docenteId);
}
