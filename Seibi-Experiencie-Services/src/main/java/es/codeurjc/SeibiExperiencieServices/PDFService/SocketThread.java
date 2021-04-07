package es.codeurjc.SeibiExperiencieServices.PDFService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.lowagie.text.pdf.PdfPTable;

import es.codeurjc.SeibiExperiencieSpring.model.Orderz;



public class SocketThread implements Runnable {
	Socket socket;
	public SocketThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		
		try {
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			BufferedReader leerServidor =new BufferedReader(new InputStreamReader(socket.getInputStream()));
			List<String> listaPedido = new ArrayList<String>();
			try {
				String r = leerServidor.readLine();
				while(r!=null) {
					listaPedido.add(r);
					r = leerServidor.readLine();
				}
			}catch (IOException e) {
				is.close();
				os.close();
				socket.close();
			}
			PDFExporter exporter = new PDFExporter("Esto es una prueba");
			exporter.export(listaPedido);
			// Envío y recepción de información
			System.out.println("Pedido generado con éxito");

			is.close();
			os.close();
			socket.close();
		} catch (IOException e) {
			System.out.println("Fallo en la conexión.");
		}
	}
}
