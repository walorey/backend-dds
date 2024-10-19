package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Alumno;
import com.example.demo.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService {
	
	@Autowired
	AlumnoRepository repository;

	@Override
	public List<Alumno> getAll() {
		return repository.findAll();
	}
	
    @Override
    public Alumno save(Alumno alumno) {
        return repository.save(alumno); // Guardar el alumno
    }

}

