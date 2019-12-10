package com.proyeto.escuelamanejo.servicios;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyeto.escuelamanejo.entidades.Alumno;

public interface AlumnoServicio {

	List<Alumno> getAllAlumnos();

	boolean createPdf(List<Alumno> alumnos, ServletContext context, HttpServletRequest request,
			HttpServletResponse response);

}
