package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.entity.Alumno;
import com.example.demo.entity.Curso;
import com.example.demo.repository.CursoRepository;
import com.example.demo.service.AlumnoServiceImpl.ResourceNotFoundException;

import jakarta.transaction.Transactional;

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
    
    @Override
    public Curso updateCurso(Curso curso) {
        // Verifica si el curso existe en la base de datos
        if (!cursoRepository.existsById(curso.getId())) {
            throw new ResourceNotFoundException("Alumno no encontrado con ID: " + curso.getId());
        }
        return cursoRepository.save(curso); // Guarda el curso actualizado
    }
    
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }
    
    @Transactional
    @Override
    public void deleteCurso(Long id) {
        if(!cursoRepository.existsById(id)){
        	throw new ResourceNotFoundException("Cursoo no encontrado con id"+id);
        }
        cursoRepository.deleteById(id);
    }
    
    // Implementación del método para obtener un curso por ID
    @Override
    public Curso getCursoById(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }
}
