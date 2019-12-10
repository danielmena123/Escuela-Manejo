package com.proyeto.escuelamanejo.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyeto.escuelamanejo.entidades.Alumno;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Integer>{


}
