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
    
    

    // Endpoint para actualizar un curso
    @PutMapping("/cursos/{id}")
    public Curso updateCurso(@PathVariable Long id, @RequestBody Curso curso) {
        curso.setId(id); // Asegura que el ID en el objeto coincide con el ID de la URL
        return cursoService.updateCurso(curso);
    }
    
    //metodo para borrar curso
    @DeleteMapping("/cursos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Devuelve 204 No Content si se elimina correctamente
    public void deleteCurso(@PathVariable Long id) {
        cursoService.deleteCurso(id);
    }
    
    // Método para obtener un curso por su ID
    @GetMapping("/cursos/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable Long id) {
    	Curso curso = cursoService.getCursoById(id);

        if (curso != null) {
            return ResponseEntity.ok(curso);
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 si el curso no se encuentra
        }
    }

}
