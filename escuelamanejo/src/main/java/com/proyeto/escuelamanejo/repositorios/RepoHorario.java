package com.proyeto.escuelamanejo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyeto.escuelamanejo.entidades.Horario;

@Repository
public interface RepoHorario extends JpaRepository<Horario, Integer>{

}
