package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    // Método para encontrar cursos que finalizan en una fecha específica
    List<Curso> findByFechaFin(Date fechaFin);
}
