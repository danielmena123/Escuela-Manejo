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
import com.itextpdf.text.pdf.Pfm2afm;
import com.proyeto.escuelamanejo.entidades.Contrato;
import com.proyeto.escuelamanejo.repositorios.ContratoRepository;

@Service
@Transactional
public class ContratoServicioImpl implements ContratoServicio {
	
	@Autowired private ContratoRepository contratoRepositorio;
	
	@Override
	public List<Contrato> getAllContratos() {
		// TODO Auto-generated method stub
		return (List<Contrato>) contratoRepositorio.findAll();
	} 

	@Override
	public boolean createPdf(List<Contrato> contratos, ServletContext context, HttpServletRequest request, HttpServletResponse response) {
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
				PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file+"/"+"contratos"+".pdf"));
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
				
				
				Paragraph paragraph = new Paragraph("*********************** Reporte de Contratos ***********************", mainFont);
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
				
				PdfPCell fechacontrato = new PdfPCell(new Paragraph("Fecha Contrato", tableHeader));
				fechacontrato.setBorderColor(BaseColor.BLACK);
				fechacontrato.setPaddingLeft(10);
				fechacontrato.setHorizontalAlignment(Element.ALIGN_CENTER);
				fechacontrato.setVerticalAlignment(Element.ALIGN_CENTER);
				fechacontrato.setBackgroundColor(BaseColor.ORANGE);
				fechacontrato.setExtraParagraphSpace(5f);
				table.addCell(fechacontrato);
				
				PdfPCell alumno = new PdfPCell(new Paragraph("Alumno", tableHeader));
				alumno.setBorderColor(BaseColor.BLACK);
				alumno.setPaddingLeft(10);
				alumno.setHorizontalAlignment(Element.ALIGN_CENTER);
				alumno.setVerticalAlignment(Element.ALIGN_CENTER);
				alumno.setBackgroundColor(BaseColor.ORANGE);
				alumno.setExtraParagraphSpace(5f);
				table.addCell(alumno);
				
				PdfPCell instructor = new PdfPCell(new Paragraph("Instructor", tableHeader));
				instructor.setBorderColor(BaseColor.BLACK);
				instructor.setPaddingLeft(10);
				instructor.setHorizontalAlignment(Element.ALIGN_CENTER);
				instructor.setVerticalAlignment(Element.ALIGN_CENTER);
				instructor.setBackgroundColor(BaseColor.ORANGE);
				instructor.setExtraParagraphSpace(5f);
				table.addCell(instructor);
				
				PdfPCell montofinal = new PdfPCell(new Paragraph("Precio", tableHeader));
				montofinal.setBorderColor(BaseColor.BLACK);
				montofinal.setPaddingLeft(10);
				montofinal.setHorizontalAlignment(Element.ALIGN_CENTER);
				montofinal.setVerticalAlignment(Element.ALIGN_CENTER);
				montofinal.setBackgroundColor(BaseColor.ORANGE);
				montofinal.setExtraParagraphSpace(5f);
				table.addCell(montofinal);
				
				PdfPCell servicio = new PdfPCell(new Paragraph("Servicio", tableHeader));
				servicio.setBorderColor(BaseColor.BLACK);
				servicio.setPaddingLeft(10);
				servicio.setHorizontalAlignment(Element.ALIGN_CENTER);
				servicio.setVerticalAlignment(Element.ALIGN_CENTER);
				servicio.setBackgroundColor(BaseColor.ORANGE);
				servicio.setExtraParagraphSpace(5f); 
				table.addCell(servicio);
				
				for (Contrato contrato : contratos) {
					
					PdfPCell fechacontratoValue = new PdfPCell(new Paragraph(contrato.getFechacontrato().toString(), tableBody));
					fechacontratoValue.setBorderColor(BaseColor.BLACK);
					fechacontratoValue.setPaddingLeft(10);
					fechacontratoValue.setHorizontalAlignment(Element.ALIGN_CENTER);
					fechacontratoValue.setVerticalAlignment(Element.ALIGN_CENTER);
					fechacontratoValue.setBackgroundColor(BaseColor.WHITE);
					fechacontratoValue.setExtraParagraphSpace(5f);
					table.addCell(fechacontratoValue);
					
					PdfPCell alumnoValue = new PdfPCell(new Paragraph(contrato.getAlumno().toString(), tableBody));
					alumnoValue.setBorderColor(BaseColor.BLACK);
					alumnoValue.setPaddingLeft(10);
					alumnoValue.setHorizontalAlignment(Element.ALIGN_CENTER);
					alumnoValue.setVerticalAlignment(Element.ALIGN_CENTER);
					alumnoValue.setBackgroundColor(BaseColor.WHITE);
					alumnoValue.setExtraParagraphSpace(5f);
					table.addCell(alumnoValue);
					
					PdfPCell instructorValue = new PdfPCell(new Paragraph(contrato.getInstructor().toString(), tableBody));
					instructorValue.setBorderColor(BaseColor.BLACK);
					instructorValue.setPaddingLeft(10);
					instructorValue.setHorizontalAlignment(Element.ALIGN_CENTER);
					instructorValue.setVerticalAlignment(Element.ALIGN_CENTER);
					instructorValue.setBackgroundColor(BaseColor.WHITE);
					instructorValue.setExtraParagraphSpace(5f);
					table.addCell(instructorValue);
					//
					//PdfPCell montofinalValue = new PdfPCell(new Paragraph(contrato.getMontofinal()));    Float.valueof(double)??
					//PdfPCell montofinalValue = new PdfPCell(new Paragraph(contrato.getMontofinal()));
				/*	PdfPCell montofinalValue = new PdfPCell(Float.valueOf(contrato.getMontofinal())).;
					montofinalValue.setBorderColor(BaseColor.BLACK);
					montofinalValue.setPaddingLeft(10);
					montofinalValue.setHorizontalAlignment(Element.ALIGN_CENTER);
					montofinalValue.setVerticalAlignment(Element.ALIGN_CENTER);
					montofinalValue.setBackgroundColor(BaseColor.WHITE);
					montofinalValue.setExtraParagraphSpace(5f);
					table.addCell(montofinalValue);    */
					
					PdfPCell servicioValue = new PdfPCell(new Paragraph(contrato.getServicio().toString(), tableBody));
					//PdfPCell servicioValue = new PdfPCell(new Paragraph(contrato.getServicio(), tableBody));
					servicioValue.setBorderColor(BaseColor.BLACK);
					servicioValue.setPaddingLeft(10);
					servicioValue.setHorizontalAlignment(Element.ALIGN_CENTER);
					servicioValue.setVerticalAlignment(Element.ALIGN_CENTER);
					servicioValue.setBackgroundColor(BaseColor.WHITE);
					servicioValue.setExtraParagraphSpace(5f);
					table.addCell(servicioValue);
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
