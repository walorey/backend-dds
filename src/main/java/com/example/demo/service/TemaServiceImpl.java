package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Alumno;
import com.example.demo.entity.Tema;
import com.example.demo.repository.TemaRepository;

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
    
}
