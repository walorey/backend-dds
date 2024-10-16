package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
