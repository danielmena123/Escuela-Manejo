package com.proyeto.escuelamanejo.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyeto.escuelamanejo.entidades.Alumno;
import com.proyeto.escuelamanejo.entidades.Contrato;

@Repository
public interface ContratoRepository extends CrudRepository<Contrato, Integer>{

}
