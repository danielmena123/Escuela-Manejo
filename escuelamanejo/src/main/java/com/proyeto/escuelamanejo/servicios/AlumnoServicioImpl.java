package com.proyeto.escuelamanejo.servicios;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.proyeto.escuelamanejo.entidades.Alumno;
import com.proyeto.escuelamanejo.repositorios.AlumnoRepository;

@Service
@Transactional
public class AlumnoServicioImpl implements AlumnoServicio {
	
	@Autowired private AlumnoRepository alumnoRepositorio;
	
	@Override
	public List<Alumno> getAllAlumnos() {
		// TODO Auto-generated method stub
		return (List<Alumno>) alumnoRepositorio.findAll();
	} 

	@Override
	public boolean createPdf(List<Alumno> alumnos, ServletContext context, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Document document = new Document(PageSize.A4, 15, 15, 45, 30);
		try {
			String filePath = context.getRealPath("/resources/reports");
			File file = new File(filePath);
			boolean exists = new File(filePath).exists();
			if (!exists) {
				new File(filePath).mkdirs();
			}
				PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file+"/"+"alumnos"+".pdf"));
				document.open();
				
				Font mainFont = FontFactory.getFont("Arial", 10, BaseColor.BLACK);
				
				Paragraph paragraph = new Paragraph("Todos los Alumnos", mainFont);
				paragraph.setAlignment(Element.ALIGN_CENTER);
				paragraph.setIndentationLeft(50);
				paragraph.setIndentationRight(50);
				paragraph.setSpacingAfter(10);
				document.add(paragraph);
				
				PdfPTable  table = new PdfPTable(4);
				table.setWidthPercentage(100);
				table.setSpacingBefore(10f);
				table.setSpacingAfter(10);
				
				Font tableHeader = FontFactory.getFont("Arial", 10, BaseColor.BLACK);
				Font tableBody = FontFactory.getFont("Arial", 9, BaseColor.BLACK);
				
				float[] columnWidths = {2f, 2f, 2f, 2f};
				table.setWidths(columnWidths);
				
				PdfPCell nombre = new PdfPCell(new Paragraph("Nombres", tableHeader));
				nombre.setBorderColor(BaseColor.BLACK);
				nombre.setPaddingLeft(10);
				nombre.setHorizontalAlignment(Element.ALIGN_CENTER);
				nombre.setVerticalAlignment(Element.ALIGN_CENTER);
				nombre.setBackgroundColor(BaseColor.GRAY);
				nombre.setExtraParagraphSpace(5f);
				table.addCell(nombre);
				
				PdfPCell apellido = new PdfPCell(new Paragraph("Apellidos", tableHeader));
				apellido.setBorderColor(BaseColor.BLACK);
				apellido.setPaddingLeft(10);
				apellido.setHorizontalAlignment(Element.ALIGN_CENTER);
				apellido.setVerticalAlignment(Element.ALIGN_CENTER);
				apellido.setBackgroundColor(BaseColor.GRAY);
				apellido.setExtraParagraphSpace(5f);
				table.addCell(apellido);
				
				PdfPCell dui = new PdfPCell(new Paragraph("Dui", tableHeader));
				dui.setBorderColor(BaseColor.BLACK);
				dui.setPaddingLeft(10);
				dui.setHorizontalAlignment(Element.ALIGN_CENTER);
				dui.setVerticalAlignment(Element.ALIGN_CENTER);
				dui.setBackgroundColor(BaseColor.GRAY);
				dui.setExtraParagraphSpace(5f);
				table.addCell(dui);
				
				PdfPCell direccion = new PdfPCell(new Paragraph("Direccion", tableHeader));
				direccion.setBorderColor(BaseColor.BLACK);
				direccion.setPaddingLeft(10);
				direccion.setHorizontalAlignment(Element.ALIGN_CENTER);
				direccion.setVerticalAlignment(Element.ALIGN_CENTER);
				direccion.setBackgroundColor(BaseColor.GRAY);
				direccion.setExtraParagraphSpace(5f);
				table.addCell(direccion);
				
				for (Alumno alumno : alumnos) {
					
					PdfPCell nombreValue = new PdfPCell(new Paragraph(alumno.getNombre(), tableBody));
					nombreValue.setBorderColor(BaseColor.BLACK);
					nombreValue.setPaddingLeft(10);
					nombreValue.setHorizontalAlignment(Element.ALIGN_CENTER);
					nombreValue.setVerticalAlignment(Element.ALIGN_CENTER);
					nombreValue.setBackgroundColor(BaseColor.WHITE);
					nombreValue.setExtraParagraphSpace(5f);
					table.addCell(nombreValue);
					
					PdfPCell apellidoValue = new PdfPCell(new Paragraph(alumno.getApellido(), tableBody));
					apellidoValue.setBorderColor(BaseColor.BLACK);
					apellidoValue.setPaddingLeft(10);
					apellidoValue.setHorizontalAlignment(Element.ALIGN_CENTER);
					apellidoValue.setVerticalAlignment(Element.ALIGN_CENTER);
					apellidoValue.setBackgroundColor(BaseColor.WHITE);
					apellidoValue.setExtraParagraphSpace(5f);
					table.addCell(apellidoValue);
					
					PdfPCell duiValue = new PdfPCell(new Paragraph(alumno.getDui(), tableBody));
					duiValue.setBorderColor(BaseColor.BLACK);
					duiValue.setPaddingLeft(10);
					duiValue.setHorizontalAlignment(Element.ALIGN_CENTER);
					duiValue.setVerticalAlignment(Element.ALIGN_CENTER);
					duiValue.setBackgroundColor(BaseColor.WHITE);
					duiValue.setExtraParagraphSpace(5f);
					table.addCell(duiValue);
					
					PdfPCell direccionValue = new PdfPCell(new Paragraph(alumno.getDireccion(), tableBody));
					direccionValue.setBorderColor(BaseColor.BLACK);
					direccionValue.setPaddingLeft(10);
					direccionValue.setHorizontalAlignment(Element.ALIGN_CENTER);
					direccionValue.setVerticalAlignment(Element.ALIGN_CENTER);
					direccionValue.setBackgroundColor(BaseColor.WHITE);
					direccionValue.setExtraParagraphSpace(5f);
					table.addCell(direccionValue);
				}
				
				document.add(table);
				document.close();
				writer.close();
				return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

}
