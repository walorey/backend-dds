package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Curso;
import com.example.demo.repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {
	
	@Autowired
	CursoRepository repository;

	@Override
	public List<Curso> getAll() {
		return repository.findAll();
	}

}
