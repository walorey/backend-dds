package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Alumno;
import com.example.demo.entity.Docente;
import com.example.demo.service.DocenteService;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200") // Permite solicitudes de este origen

@RestController
public class DocenteController {
	@Autowired
	DocenteService service;
	
	@GetMapping("/docentes")
	public List<Docente> getAll() {
		return service.getAll();
		
	}

	@PostMapping("/docentes")
	public Docente createDocente(@RequestBody Docente docente) {
	    return service.save(docente);
	}
	
    // Endpoint para actualizar un docente
    @PutMapping("/docentes/{id}")
    public Docente updateDocente(@PathVariable Long id, @RequestBody Docente docente) {
        docente.setId(id); // Asegura que el ID en el objeto coincide con el ID de la URL
        return service.updateDocente(docente);
    }
    
    @DeleteMapping("/docentes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Devuelve 204 No Content si se elimina correctamente
    public void deleteDocente(@PathVariable Long id) {
        service.deleteDocente(id);
    }
    
    // Método para obtener un docente por su ID
    @GetMapping("/docentes/{id}")
    public ResponseEntity<Docente> getDocenteById(@PathVariable Long id) {
    	Docente docente = service.getDocenteById(id);

        if (docente != null) {
            return ResponseEntity.ok(docente);
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 si el alumno no se encuentra
        }
    }
}
