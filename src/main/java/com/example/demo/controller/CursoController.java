package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;  // Importa todas las anotaciones REST

import com.example.demo.entity.Alumno;
import com.example.demo.entity.Curso;
import com.example.demo.service.CursoService;

@RestController
public class CursoController {

   @Autowired
   private CursoService cursoService;

   // GET para obtener todos los cursos
   @GetMapping("/cursos")
   public ResponseEntity<List<Curso>> getAllCursos() {
       List<Curso> cursos = cursoService.getAll();
       return new ResponseEntity<>(cursos, HttpStatus.OK);
   }

    @PostMapping("/cursos")
    public ResponseEntity<Curso> crearCurso(@RequestBody Curso curso) {
        Curso nuevoCurso = cursoService.crearCurso(curso);
        return new ResponseEntity<>(nuevoCurso, HttpStatus.CREATED);
    }


}
