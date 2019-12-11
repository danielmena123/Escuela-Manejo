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
import com.itextpdf.text.Image;
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
		
		//creacion del documento con margenes
		Document document = new Document(PageSize.A4, 25, 20, 45, 30);
		try {
			String filePath = context.getRealPath("/resources/reports");
			File file = new File(filePath);
			boolean exists = new File(filePath).exists();
			if (!exists) {
				new File(filePath).mkdirs();
			}
			//archivo pdf que vamos a generar
				PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file+"/"+"alumnos"+".pdf"));
				document.open();
				
				Font mainFont = FontFactory.getFont("Arial", 12, BaseColor.BLACK);
			
				// *****************************************************************
				Image image = null;
				 
				// Obtenemos el logo de datojava
				image = Image.getInstance("1.jpg");
				image.scaleAbsolute(2f, 2f);
				image.setWidthPercentage(2f);
				 
				PdfPTable table1 = new PdfPTable(5); 

				table1.setWidthPercentage(100);
				table1.setSpacingBefore(20f);
				table1.setSpacingAfter(20f);
				
				Font letra = FontFactory.getFont("Arial", 30, BaseColor.BLUE);
				
				PdfPCell celdaFinal1 = new PdfPCell(); 
				celdaFinal1.setExtraParagraphSpace(4f);
				celdaFinal1.setImage(image);
				celdaFinal1.setBorderColor(BaseColor.WHITE);
				table1.addCell(celdaFinal1);
				
				PdfPCell celdaFinal = new PdfPCell(new Paragraph("Escuela de Manejo ''SHALOM''", letra));
				celdaFinal.setColspan(3);
				celdaFinal.setBorderColor(BaseColor.WHITE);
				celdaFinal.setPaddingTop(25);
				celdaFinal.setExtraParagraphSpace(4f);
				celdaFinal.setPaddingLeft(10);
				celdaFinal.setHorizontalAlignment(Element.ALIGN_CENTER);
				celdaFinal.setVerticalAlignment(Element.ALIGN_CENTER);
				table1.addCell(celdaFinal);
				
				PdfPCell celdaFinal2 = new PdfPCell();
				celdaFinal2.setExtraParagraphSpace(4f);
				celdaFinal2.setBorderColor(BaseColor.WHITE);
				celdaFinal2.setImage(image);
				table1.addCell(celdaFinal2);
				
				
				Paragraph paragraph = new Paragraph("*********************** Reporte de Alumn@s ***********************", mainFont);
				paragraph.setAlignment(Element.ALIGN_CENTER);
				paragraph.setSpacingAfter(20);
	         // *****************************************************************
	            
				PdfPTable  table = new PdfPTable(5);
				table.setWidthPercentage(100);
				table.setSpacingBefore(20f);
				table.setSpacingAfter(20);
				
				Font tableHeader = FontFactory.getFont("Arial", 12, BaseColor.BLACK);
				Font tableBody = FontFactory.getFont("Arial", 11, BaseColor.BLACK);
				
				float[] columnWidths = {8f, 8f, 8f, 8f, 8f};
				table.setWidths(columnWidths);
				
				PdfPCell nombre = new PdfPCell(new Paragraph("Nombres", tableHeader));
				nombre.setBorderColor(BaseColor.BLACK);
				nombre.setPaddingLeft(10);
				nombre.setHorizontalAlignment(Element.ALIGN_CENTER);
				nombre.setVerticalAlignment(Element.ALIGN_CENTER);
				nombre.setBackgroundColor(BaseColor.ORANGE);
				nombre.setExtraParagraphSpace(5f);
				table.addCell(nombre);
				
				PdfPCell apellido = new PdfPCell(new Paragraph("Apellidos", tableHeader));
				apellido.setBorderColor(BaseColor.BLACK);
				apellido.setPaddingLeft(10);
				apellido.setHorizontalAlignment(Element.ALIGN_CENTER);
				apellido.setVerticalAlignment(Element.ALIGN_CENTER);
				apellido.setBackgroundColor(BaseColor.ORANGE);
				apellido.setExtraParagraphSpace(5f);
				table.addCell(apellido);
				
				PdfPCell dui = new PdfPCell(new Paragraph("Dui", tableHeader));
				dui.setBorderColor(BaseColor.BLACK);
				dui.setPaddingLeft(10);
				dui.setHorizontalAlignment(Element.ALIGN_CENTER);
				dui.setVerticalAlignment(Element.ALIGN_CENTER);
				dui.setBackgroundColor(BaseColor.ORANGE);
				dui.setExtraParagraphSpace(5f);
				table.addCell(dui);
				
				PdfPCell telefono = new PdfPCell(new Paragraph("Telefono", tableHeader));
				telefono.setBorderColor(BaseColor.BLACK);
				telefono.setPaddingLeft(10);
				telefono.setHorizontalAlignment(Element.ALIGN_CENTER);
				telefono.setVerticalAlignment(Element.ALIGN_CENTER);
				telefono.setBackgroundColor(BaseColor.ORANGE);
				telefono.setExtraParagraphSpace(5f);
				table.addCell(telefono);
				
				PdfPCell direccion = new PdfPCell(new Paragraph("Direccion", tableHeader));
				direccion.setBorderColor(BaseColor.BLACK);
				direccion.setPaddingLeft(10);
				direccion.setHorizontalAlignment(Element.ALIGN_CENTER);
				direccion.setVerticalAlignment(Element.ALIGN_CENTER);
				direccion.setBackgroundColor(BaseColor.ORANGE);
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
					
					PdfPCell telValue = new PdfPCell(new Paragraph(alumno.getTelefono(), tableBody));
					telValue.setBorderColor(BaseColor.BLACK);
					telValue.setPaddingLeft(10);
					telValue.setHorizontalAlignment(Element.ALIGN_CENTER);
					telValue.setVerticalAlignment(Element.ALIGN_CENTER);
					telValue.setBackgroundColor(BaseColor.WHITE);
					telValue.setExtraParagraphSpace(5f);
					table.addCell(telValue);
					
					PdfPCell direccionValue = new PdfPCell(new Paragraph(alumno.getDireccion(), tableBody));
					direccionValue.setBorderColor(BaseColor.BLACK);
					direccionValue.setPaddingLeft(10);
					direccionValue.setHorizontalAlignment(Element.ALIGN_CENTER);
					direccionValue.setVerticalAlignment(Element.ALIGN_CENTER);
					direccionValue.setBackgroundColor(BaseColor.WHITE);
					direccionValue.setExtraParagraphSpace(5f);
					table.addCell(direccionValue);
				}
				
				document.add(table1);
				document.add(paragraph);
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
