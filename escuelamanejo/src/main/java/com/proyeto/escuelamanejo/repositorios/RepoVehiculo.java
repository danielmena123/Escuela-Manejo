package com.proyeto.escuelamanejo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyeto.escuelamanejo.entidades.Vehiculo;

@Repository
public interface RepoVehiculo extends JpaRepository<Vehiculo, Integer>{

}
