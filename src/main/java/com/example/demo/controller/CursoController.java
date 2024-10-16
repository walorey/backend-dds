package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Curso;
import com.example.demo.service.CursoService;

@RestController
public class CursoController {
	@Autowired
	CursoService service;
	
	@GetMapping("/cursos")
	public List<Curso> getAll() {
		return service.getAll();
	}
}
