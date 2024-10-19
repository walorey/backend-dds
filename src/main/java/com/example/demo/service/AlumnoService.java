package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Alumno;

public interface AlumnoService {

	List<Alumno> getAll();
	
	Alumno save(Alumno alumno); // Método para guardar un alumno
	
	 Alumno updateAlumno(Alumno alumno); // Método para actualizar

}
