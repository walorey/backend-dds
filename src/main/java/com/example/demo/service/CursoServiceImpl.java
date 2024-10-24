package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Curso;
import com.example.demo.repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<Curso> getAll() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso crearCurso(Curso curso) {
        return cursoRepository.save(curso);
    }
}
