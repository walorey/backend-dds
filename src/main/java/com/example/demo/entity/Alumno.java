//cada uno de estas clases necesita un repository y un services
package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "alumno")
public class Alumno {
	
	@Id
	private Long id;

	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;
    
	/*@ManyToMany(mappedBy = "alumnos")
	@JsonBackReference
	private List<Curso> cursos;*/

    
	public Alumno() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
   /* public List<Curso> getCursos() { // Método getter para cursos
        return cursos;
    }

    public void setCursos(List<Curso> cursos) { // Método setter para cursos
        this.cursos = cursos;
    }*/
}
