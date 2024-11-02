package com.example.demo.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

   //--- CRUD----//
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

	    
	    // Endpoint para obtener cursos que finalizan en una fecha específica
	    @GetMapping("/cursos/finalizan")
	    public ResponseEntity<List<Curso>> getCursosByFechaFin(
	        @RequestParam("fechaFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin) {
	        
	        List<Curso> cursos = cursoService.findCursosByFechaFin(fechaFin);
	        return new ResponseEntity<>(cursos, HttpStatus.OK);
	    }
	    
	    // Endpoint para obtener los cursos vigentes de un docente junto con los alumnos
	    @GetMapping("/{docenteId}/cursos-vigentes")
	    public ResponseEntity<List<Curso>> getCursosVigentesByDocente(@PathVariable Long docenteId) {
	        List<Curso> cursos = cursoService.getCursosVigentesByDocenteId(docenteId);
	        return new ResponseEntity<>(cursos, HttpStatus.OK);
	    }
}
