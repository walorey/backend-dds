package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import com.example.demo.entity.Alumno;
import com.example.demo.repository.AlumnoRepository; // Importa el repositorio
import com.example.demo.entity.Alumno;
import jakarta.transaction.Transactional;

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
    
    @Transactional
    @Override
    public void deleteAlumno(Long id) {
        // Primero elimina las relaciones en la tabla curso_alumno si es necesario
        Alumno alumno = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Alumno no encontrado con ID: " + id));

        alumno.getCursos().forEach(curso -> curso.getAlumnos().remove(alumno)); // Romper relaciones sin borrar el curso

        repository.deleteById(id); // Elimina el alumno
    }

}

