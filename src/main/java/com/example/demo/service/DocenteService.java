package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Alumno;
import com.example.demo.entity.Docente;

public interface DocenteService {

	List<Docente> getAll();
	
	Docente save(Docente docente); // Método para guardar un docente
	
	Docente updateDocente(Docente docente); // Método para actualizar
	
	void deleteDocente(Long id); //Metodo para borrar
	
	Docente getDocenteById(Long id);

}

