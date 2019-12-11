package com.proyeto.escuelamanejo.controladores;

import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//import com.itextpdf.text.pdf.codec.Base64.OutputStream;
import com.proyeto.escuelamanejo.entidades.Alumno;
import com.proyeto.escuelamanejo.entidades.Contrato;
import com.proyeto.escuelamanejo.servicios.AlumnoServicio;
import com.proyeto.escuelamanejo.servicios.ContratoServicio;

@Controller
public class PDFControlador {
	
	@Autowired private AlumnoServicio alumnoServicio;
	@Autowired private ContratoServicio contratoServicio;
	@Autowired private ServletContext context;
	
	@GetMapping(value="/otro")
	public String allAlumnos(Model model) {
		List<Alumno> alumnos = alumnoServicio.getAllAlumnos();
		model.addAttribute("alumnos", alumnos);
		return "verAlumnos";
	}
	
	@GetMapping("/crearPDF")
	public void createPdf(HttpServletRequest request, HttpServletResponse response) {
		List<Alumno> alumnos = alumnoServicio.getAllAlumnos();
		boolean isFlag = alumnoServicio.createPdf(alumnos, context, request, response);
		if (isFlag) {
			String fullPath = request.getServletContext().getRealPath("/resources/reports/"+"alumnos"+".pdf");
			filedownload(fullPath, response, "alumnos.pdf");
		}
	}
	
	@GetMapping("/crearPDF2")
	public void createPdf2(HttpServletRequest request, HttpServletResponse response) {
		List<Contrato> contratos = contratoServicio.getAllContratos();
		boolean isFlag = contratoServicio.createPdf(contratos, context, request, response);
		if (isFlag) {
			String fullPath = request.getServletContext().getRealPath("/resources/reports/"+"contratos"+".pdf");
			filedownload2(fullPath, response, "contratos.pdf");
		}
	}

	private void filedownload(String fullPath, HttpServletResponse response, String fileName) {
		// TODO Auto-generated method stub
		File file = new File(fullPath);
		final int BUFFER_SIZE = 4096;
		if (file.exists()) {
			try {
				FileInputStream inputStream = new FileInputStream(file);
				String mimeType = context.getMimeType(fullPath);
				response.setContentType(mimeType);
				response.setHeader("content-disposition", "attachment; filename="+fileName);
				OutputStream outputStream = response.getOutputStream();
				byte[] buffer = new byte[BUFFER_SIZE];
				int bytesRead = -1;
				while ((bytesRead = inputStream.read(buffer))!= -1) {
					outputStream.write(buffer, 0, bytesRead);
				}
				inputStream.close();
				outputStream.close();
				file.delete();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	
	private void filedownload2(String fullPath, HttpServletResponse response, String fileName) {
		// TODO Auto-generated method stub
		File file = new File(fullPath);
		final int BUFFER_SIZE = 4096;
		if (file.exists()) {
			try {
				FileInputStream inputStream = new FileInputStream(file);
				String mimeType = context.getMimeType(fullPath);
				response.setContentType(mimeType);
				response.setHeader("content-disposition", "attachment; filename="+fileName);
				OutputStream outputStream = response.getOutputStream();
				byte[] buffer = new byte[BUFFER_SIZE];
				int bytesRead = -1;
				while ((bytesRead = inputStream.read(buffer))!= -1) {
					outputStream.write(buffer, 0, bytesRead);
				}
				inputStream.close();
				outputStream.close();
				file.delete();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		/* */
		
	}

}
