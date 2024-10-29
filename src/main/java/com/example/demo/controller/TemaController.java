package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
}

