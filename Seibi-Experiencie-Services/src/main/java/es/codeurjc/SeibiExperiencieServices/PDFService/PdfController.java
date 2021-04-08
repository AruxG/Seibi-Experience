package es.codeurjc.SeibiExperiencieServices.PDFService;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfPTable;

import es.codeurjc.SeibiExperiencieSpring.model.Orderz;

@RestController
public class PdfController {

	@Autowired
	MailService mail;
	
	@PostConstruct
	public void index() throws IOException{
		Thread t = new Thread(() -> {
			int port = 6666;
			ServerSocket serverSocket;
			try {
				serverSocket = new ServerSocket(port);
				Socket socket;
				while (true) {
					socket = serverSocket.accept();
					Thread te = new Thread(new SocketThread(socket));
					te.start();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
		});
		t.start();
	}
	

	@RequestMapping(value = "/generate/pdf.htm", method = RequestMethod.GET)
	ModelAndView generatePdf(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Calling generatePdf()...");

		Order pedido = null;

		ModelAndView modelAndView = new ModelAndView("pdfView", "command", pedido);
		// https://www.technicalkeeda.com/spring-tutorials/generate-pdf-using-spring-framework
		// URL con info↑
		return modelAndView;
	}

}
