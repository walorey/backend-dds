package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    // Método para encontrar cursos que finalizan en una fecha específica
    List<Curso> findByFechaFin(Date fechaFin);
    
    //Metodo para obtener cursos vigentes de un profesor
    @Query("SELECT c FROM Curso c WHERE c.docente.id = :docenteId AND c.fechaFin > CURRENT_DATE")
    List<Curso> findVigentesByDocenteId(@Param("docenteId") Long docenteId);
}
