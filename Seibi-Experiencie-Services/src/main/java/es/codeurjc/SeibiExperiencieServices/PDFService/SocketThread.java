package es.codeurjc.SeibiExperiencieServices.PDFService;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.lowagie.text.pdf.PdfPTable;

import es.codeurjc.SeibiExperiencieServices.model.Orderz;



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
			ObjectInputStream ois= new ObjectInputStream(is);
			
			Orderz pedido= (Orderz) ois.readObject();
			table.addCell(pedido.getUser().toString());
			table.addCell("Ole");
			table.addCell("Ole");
			table.addCell("Ole");
			System.out.println("Pedido generado con éxito");
			ois.close();
			is.close();
			os.close();
			socket.close();
		} catch (IOException e) {
			System.out.println("Fallo en la conexión.");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
