package com.example.demo.entity;

import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Ajuste para AUTO_INCREMENT
    private Long id;

    @Column(name = "fecha_inicio")  // Ajuste para coincidir con la base de datos
    private Date fechaInicio;

    @Column(name = "fecha_fin")  // Ajuste para coincidir con la base de datos
    private Date fechaFin;

    @Column(name = "precio")
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "docente_id") // Clave foránea a la tabla docente
    private Docente docente;

    @ManyToOne
    @JoinColumn(name = "tema_id") // Clave foránea a la tabla tema
    private Tema tema;

    @ManyToMany
    @JoinTable(
        name = "curso_alumno",
        joinColumns = @JoinColumn(name = "curso_id"),
        inverseJoinColumns = @JoinColumn(name = "alumno_id")
    )
    //@JsonManagedReference // Esta anotación gestiona la serialización en la relación bidireccional
    private List<Alumno> alumnos;

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
