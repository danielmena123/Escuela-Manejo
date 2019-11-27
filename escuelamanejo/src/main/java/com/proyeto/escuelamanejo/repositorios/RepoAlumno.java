package com.proyeto.escuelamanejo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyeto.escuelamanejo.entidades.Alumno;

@Repository
public interface RepoAlumno extends JpaRepository<Alumno, Integer>{

}
