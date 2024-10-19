package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
