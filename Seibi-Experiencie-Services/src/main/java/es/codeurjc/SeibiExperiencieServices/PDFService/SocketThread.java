package es.codeurjc.SeibiExperiencieServices.PDFService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import com.lowagie.text.pdf.PdfPTable;



public class SocketThread implements Runnable {
	Socket socket;
	PdfPTable table;
	public SocketThread(Socket socket, PdfPTable table) {
		this.socket = socket;
		this.table= table;
	}

	public void run() {
		try {
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
// Envío y recepción de información
			BufferedReader leerServidor =
					new BufferedReader(new InputStreamReader(is));
			
			table.addCell(leerServidor.readLine());
			table.addCell("Ole");
			table.addCell("Ole");
			table.addCell("Ole");
			
			is.close();
			os.close();
			socket.close();
		} catch (IOException e) {
			System.out.println("Fallo en la conexión.");
		}
	}
}
