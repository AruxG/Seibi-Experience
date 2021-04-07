package es.codeurjc.SeibiExperiencieServices.PDFService;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;


public class PDFExporter {
	
	@Autowired
	ByteToFile byteToFile;
	
	public String pedido;

	
	// public Orderz orderz;
	public PDFExporter(String pedido) {
		this.pedido = pedido;
	}
	/*
	 * public PDFExporter(Orderz orderz) { this.orderz = orderz; }
	 */

	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);
		font.setSize(11);
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
			/*int port = 7777;
			ServerSocket serverSocket = new ServerSocket(port);
			while (true) {
				Socket socket = serverSocket.accept();
				Thread t = new Thread(new SocketThread(socket, table));
				t.start();
			}*/
		table.addCell(name);
		table.addCell(activities);
		table.addCell(description);
		table.addCell(price);
		/*
		 * table.addCell(user.getFullName()); table.addCell(user.getRoles().toString());
		 * table.addCell(String.valueOf(user.isEnabled()));
		 */
	}

	public void export(List<String> pedido) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PdfWriter.getInstance(document, byteArrayOutputStream);
		//PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);

		Paragraph p = new Paragraph("Detalles del pedido", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		p = new Paragraph(pedido.get(0), font);
		p.setAlignment(Paragraph.ALIGN_LEFT);

		document.add(p);

		PdfPTable table = new PdfPTable(4);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 2.5f, 4.0f, 4.0f, 1.5f });
		table.setSpacingBefore(10);

		writeTableHeader(table);
		for(int i=0;i<Integer.parseInt(pedido.get(2));i++) {

			writeTableData(table,pedido.get(i*4+3),pedido.get(i*4+4),pedido.get(i*4+5),pedido.get(i*4+6));
		}
		document.add(table);
		p = new Paragraph("Total: "+Integer.parseInt(pedido.get(Integer.parseInt(pedido.get(2))*4+3))+"€", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);
		document.close();
		
		
		byte[] pdfBytes = byteArrayOutputStream.toByteArray();
		MailService mail = new MailService();
		
		mail.sendEmail(pedido.get(1), "Pedido", "Aquí tienes el PDF de tu pedido",pdfBytes);

	}
}
