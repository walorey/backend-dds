package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Curso;

public interface CursoService {

    // Método para obtener todos los cursos
    List<Curso> getAll();

    // Método para guardar un curso
    Curso crearCurso(Curso curso);
}
