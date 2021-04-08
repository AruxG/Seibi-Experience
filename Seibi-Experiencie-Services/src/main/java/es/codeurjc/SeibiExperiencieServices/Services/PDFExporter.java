package es.codeurjc.SeibiExperiencieServices.Services;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import es.codeurjc.SeibiExperiencieSpring.model.Orderz;
import es.codeurjc.SeibiExperiencieSpring.model.Product;


public class PDFExporter {

	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);
		font.setSize(9);
		cell.setPhrase(new Phrase("Producto", font));

		table.addCell(cell);

		cell.setPhrase(new Phrase("Actividades", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Descripción", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Precio", font));
		table.addCell(cell);

	}

	private void writeTableData(PdfPTable table,String name, String activities, String description, String price) throws IOException {
		table.addCell(name);
		table.addCell(activities);
		table.addCell(description);
		table.addCell(price);
	}

	
	public void export(Orderz orderz) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PdfWriter.getInstance(document, byteArrayOutputStream);
		//PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);

		Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font2.setSize(12);
		
		Paragraph p = new Paragraph("Detalles del pedido", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		p = new Paragraph(orderz.getUser().getName(), font);
		p.setAlignment(Paragraph.ALIGN_LEFT);

		document.add(p);
		
		p = new Paragraph("Pedido nº:"+orderz.getId(), font2);
		p.setAlignment(Paragraph.ALIGN_LEFT);
		document.add(p);
		
		p = new Paragraph(orderz.getMail(), font2);
		p.setAlignment(Paragraph.ALIGN_LEFT);
		document.add(p);
		p = new Paragraph(orderz.getDate().toString(), font2);
		p.setAlignment(Paragraph.ALIGN_LEFT);
		document.add(p);

		PdfPTable table = new PdfPTable(4);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 2.5f, 4.5f, 4.0f, 1.0f});
		table.setSpacingBefore(10);

		writeTableHeader(table);
		for(Product product:orderz.getProducts()) {

			writeTableData(table,product.getName(),product.getActivities(),product.getDescription(),""+product.getPrice());
		}
		document.add(table);
		p = new Paragraph("Total: "+orderz.getTotal()+"€", font);
		p.setAlignment(Paragraph.ALIGN_RIGHT);

		document.add(p);
		document.close();
		
		
		byte[] pdfBytes = byteArrayOutputStream.toByteArray();
		MailService mail = new MailService();
		
		mail.sendEmail(orderz.getMail(), "Pedido", "Aquí tienes el PDF de tu pedido",pdfBytes);

	}
}
