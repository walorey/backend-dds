package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Alumno;
import com.example.demo.entity.Tema;

public interface TemaService {

	List<Tema> getAll();
	
	Tema save(Tema tema); // Método para guardar un tema

}
