package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Alumno;
import com.example.demo.entity.Tema;
import com.example.demo.service.TemaService;

@RestController
public class TemaController {
	@Autowired
	TemaService service;
	
	@GetMapping("/temas")
	public List<Tema> getAll() {
		return service.getAll();
	}
	
	@PostMapping("/temas")
	public Tema createTema(@RequestBody Tema tema) {
	    return service.save(tema);
	}
	
    // Endpoint para actualizar 
    @PutMapping("/temas/{id}")
    public Tema updateTema(@PathVariable Long id, @RequestBody Tema tema) {
        tema.setId(id); // Asegura que el ID en el objeto coincide con el ID de la URL
        return service.updateTema(tema);
    }
    
    @DeleteMapping("/temas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Devuelve 204 No Content si se elimina correctamente
    public void deleteTema(@PathVariable Long id) {
        service.deleteTema(id);
    }
    
    
    // Método para obtener un tema por su ID
    @GetMapping("/temas/{id}")
    public ResponseEntity<Tema> getTemaById(@PathVariable Long id) {
    	Tema tema = service.getTemaById(id);

        if (tema != null) {
            return ResponseEntity.ok(tema);
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 si el alumno no se encuentra
        }
    }
}

