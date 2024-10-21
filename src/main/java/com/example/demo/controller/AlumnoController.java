package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Alumno;
import com.example.demo.service.AlumnoService;

@RestController
public class AlumnoController {
	@Autowired
	AlumnoService service;
	
	@GetMapping("/alumnos")
	public List<Alumno> getAll() {
		return service.getAll();
	}
	
	@PostMapping("/alumnos")
	public Alumno createAlumno(@RequestBody Alumno alumno) {
	    return service.save(alumno);
	}

    // Endpoint para actualizar un alumno
    @PutMapping("/alumnos/{id}")
    public Alumno updateAlumno(@PathVariable Long id, @RequestBody Alumno alumno) {
        alumno.setId(id); // Asegura que el ID en el objeto coincide con el ID de la URL
        return service.updateAlumno(alumno);
    }
    
    @DeleteMapping("/alumnos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Devuelve 204 No Content si se elimina correctamente
    public void deleteAlumno(@PathVariable Long id) {
        service.deleteAlumno(id);
    }
    
    // Método para obtener un alumno por su ID
    @GetMapping("/alumnos/{id}")
    public ResponseEntity<Alumno> getAlumnoById(@PathVariable Long id) {
    	Alumno alumno = service.getAlumnoById(id);

        if (alumno != null) {
            return ResponseEntity.ok(alumno);
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 si el alumno no se encuentra
        }
    }
}
