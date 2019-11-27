package com.proyeto.escuelamanejo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyeto.escuelamanejo.entidades.Instructor;

@Repository
public interface RepoInstructor extends JpaRepository<Instructor, Integer>{

}
