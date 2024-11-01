package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.entity.Alumno;
import com.example.demo.entity.Tema;
import com.example.demo.repository.TemaRepository;
import com.example.demo.service.AlumnoServiceImpl.ResourceNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class TemaServiceImpl implements TemaService {
	
	@Autowired
	TemaRepository repository;

	@Override
	public List<Tema> getAll() {
		return repository.findAll();
	}

	//para guardar tema nuevo
	@Override
	public Tema save(Tema tema) {
	    if (tema.getId() != null && repository.existsById(tema.getId())) {
	        throw new DataIntegrityViolationException("El tema con ID " + tema.getId() + " ya existe.");
	    }
	    return repository.save(tema);
	}
    
    @Override
    public Tema updateTema(Tema tema) {
        // Verifica si el alumno existe en la base de datos
        if (!repository.existsById(tema.getId())) {
            throw new ResourceNotFoundException("Alumno no encontrado con ID: " + tema.getId());
        }
        return repository.save(tema); // Guarda el alumno actualizado
    }
    
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }
    
    @Transactional
    @Override
    public void deleteTema(Long id) {
        if(!repository.existsById(id)){
        	throw new ResourceNotFoundException("Tema no encontrado con id"+id);
        }
        repository.deleteById(id);
    }
    
    // Implementación del método para obtener un tema por ID
    @Override
    public Tema getTemaById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
