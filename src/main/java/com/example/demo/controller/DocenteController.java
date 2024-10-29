package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Alumno;
import com.example.demo.entity.Docente;
import com.example.demo.service.DocenteService;

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
}
