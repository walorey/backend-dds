package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "docente")
public class Docente {
	@Id
	private Long id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="legajo")
	private Long legajo;
	
	
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
	public Long getLegajo() {
		return legajo;
	}
	public void setLegajo(Long legajo) {
		this.legajo = legajo;
	}

}
