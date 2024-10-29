package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Alumno;
import com.example.demo.entity.Docente;
import com.example.demo.repository.DocenteRepository;

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
    
}
