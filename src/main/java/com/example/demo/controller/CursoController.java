package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;  // Importa todas las anotaciones REST
import com.example.demo.entity.Curso;
import com.example.demo.service.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    // GET para obtener todos los cursos
    @GetMapping
    public ResponseEntity<List<Curso>> getAllCursos() {
        List<Curso> cursos = cursoService.getAll();
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }

    // POST para crear un curso
    @RequestMapping(value = "/cursos", method = RequestMethod.POST, produces = "application/json")
    public Curso addCurso(@RequestBody Curso curso) {
    	return cursoService.crearCurso(curso);
    }
}
