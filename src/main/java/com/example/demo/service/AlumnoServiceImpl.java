package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

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
    
    @Override
    public Alumno updateAlumno(Alumno alumno) {
        // Verifica si el alumno existe en la base de datos
        if (!repository.existsById(alumno.getId())) {
            throw new ResourceNotFoundException("Alumno no encontrado con ID: " + alumno.getId());
        }
        return repository.save(alumno); // Guarda el alumno actualizado
    }
    
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }

}

