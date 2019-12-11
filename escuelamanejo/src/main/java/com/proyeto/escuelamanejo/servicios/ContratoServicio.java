package com.proyeto.escuelamanejo.servicios;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyeto.escuelamanejo.entidades.Contrato;

public interface ContratoServicio {

	List<Contrato> getAllContratos();

	boolean createPdf(List<Contrato> contratos, ServletContext context, HttpServletRequest request,
			HttpServletResponse response);

}
