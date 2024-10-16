package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
