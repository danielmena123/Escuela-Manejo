package com.proyeto.escuelamanejo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyeto.escuelamanejo.entidades.Contrato;

@Repository
public interface RepoContrato extends JpaRepository<Contrato, Integer>{

}
