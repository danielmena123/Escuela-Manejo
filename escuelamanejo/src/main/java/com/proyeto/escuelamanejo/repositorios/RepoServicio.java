package com.proyeto.escuelamanejo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyeto.escuelamanejo.entidades.Servicio;

@Repository
public interface RepoServicio extends JpaRepository<Servicio, Integer>{

}
