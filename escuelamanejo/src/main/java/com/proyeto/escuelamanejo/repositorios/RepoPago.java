package com.proyeto.escuelamanejo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyeto.escuelamanejo.entidades.Pago;

@Repository
public interface RepoPago extends JpaRepository<Pago, Integer>{

}
