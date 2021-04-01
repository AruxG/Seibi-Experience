package es.codeurjc.SeibiExperiencieSpring.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.codeurjc.SeibiExperiencieSpring.model.Orderz;
import es.codeurjc.SeibiExperiencieSpring.repository.OrderzRepository;

@RestController
public class PDFController {

	@Autowired
	private OrderzRepository orders;
	
	@GetMapping("/pdf/{id}")
	public Orderz generarPDF(@RequestParam Long id) {
		Orderz orderz = orders.findById(id).orElseThrow();
		try {
			String host = "127.0.0.1";
			int port = 7777;
			Socket socket = new Socket(host,port);
			OutputStream out = socket.getOutputStream();
			InputStream in = socket.getInputStream();
			// Envío y recepción de información
			out.write(null);
			
			out.close();
			in.close();
			socket.close();
			} catch (UnknownHostException e) {
			System.err.println("Host desconocido");
			} catch (IOException e) {
			System.err.println("Error I/O");
			}
		return orderz;
	}
}
