package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Docente;

public interface DocenteService {

	List<Docente> getAll();
	
	Docente save(Docente docente); // Método para guardar un docente

}

