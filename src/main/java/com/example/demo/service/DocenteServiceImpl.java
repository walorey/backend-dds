package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.entity.Alumno;
import com.example.demo.entity.Docente;
import com.example.demo.repository.DocenteRepository;
import com.example.demo.service.AlumnoServiceImpl.ResourceNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class DocenteServiceImpl implements DocenteService {
	
	@Autowired
	DocenteRepository repository;

	@Override
	public List<Docente> getAll() {
		return repository.findAll();
	}

	@Override
	public Docente save(Docente docente) {
	    if (docente.getId() != null && repository.existsById(docente.getId())) {
	        throw new DataIntegrityViolationException("El docente con ID " + docente.getId() + " ya existe.");
	    }
	    return repository.save(docente);
	}
	
    @Override
    public Docente updateDocente(Docente docente) {
        // Verifica si el alumno existe en la base de datos
        if (!repository.existsById(docente.getId())) {
            throw new ResourceNotFoundException("Docente no encontrado con ID: " + docente.getId());
        }
        return repository.save(docente); // Guarda el alumno actualizado
    }
    
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }
    
    @Transactional
    @Override
    public void deleteDocente(Long id) {
        if(!repository.existsById(id)){
        	throw new ResourceNotFoundException("Docente no encontrado con id"+id);
        }
        repository.deleteById(id);
    }
    
    // Implementación del método para obtener un alumno por ID
    @Override
    public Docente getDocenteById(Long id) {
        return repository.findById(id).orElse(null);
    }
    
}
