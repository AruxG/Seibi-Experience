package es.codeurjc.SeibiExperiencieServices.PDFService;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import es.codeurjc.SeibiExperiencieSpring.model.Orderz;

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

		cell.setPhrase(new Phrase("Producto", font));

		table.addCell(cell);

		cell.setPhrase(new Phrase("Actividades", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Descripción", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Precio", font));
		table.addCell(cell);

	}

	private void writeTableData(PdfPTable table) throws IOException {
			/*int port = 7777;
			ServerSocket serverSocket = new ServerSocket(port);
			while (true) {
				Socket socket = serverSocket.accept();
				Thread t = new Thread(new SocketThread(socket, table));
				t.start();
			}*/
		table.addCell("Ole");
		table.addCell("Ole");
		table.addCell("Ole");
		table.addCell("Ole");
		/*
		 * table.addCell(user.getFullName()); table.addCell(user.getRoles().toString());
		 * table.addCell(String.valueOf(user.isEnabled()));
		 */
	}

	public void export(HttpServletResponse response) throws DocumentException, IOException {
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

		p = new Paragraph("User name", font);
		p.setAlignment(Paragraph.ALIGN_LEFT);

		document.add(p);

		PdfPTable table = new PdfPTable(4);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 2.5f, 4.0f, 4.0f, 1.5f });
		table.setSpacingBefore(10);

		writeTableHeader(table);
		writeTableData(table);

		document.add(table);
		document.close();
		
		
		byte[] pdfBytes = byteArrayOutputStream.toByteArray();
		if (pdfBytes.length > 0) {
	    	System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	    }else {
	    	System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
	    }
		//byteToFile.writeBytesToFile("./pedidoguay.pdf", pdfBytes);
		MailService mail = new MailService();
		
		mail.sendEmail("rociiocs.00@gmail.com", "Pedido", "Aquí tienes el PDF de tu pedido",pdfBytes);

	}
}
