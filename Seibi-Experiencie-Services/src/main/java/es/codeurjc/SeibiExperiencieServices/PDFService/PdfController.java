package es.codeurjc.SeibiExperiencieServices.PDFService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfPTable;

import es.codeurjc.SeibiExperiencieSpring.model.Orderz;

@Controller
public class PdfController {

	@Autowired
	MailService mail;
	
	@GetMapping("/")
	public String index(PdfPTable table, HttpServletResponse response) throws IOException, ClassNotFoundException {
		
		mail.sendEmail("rociiocs.00@gmail.com", "Pedido", "Aquí tienes el PDF de tu pedido");
		/*
		int port = 6661;
		ServerSocket serverSocket = new ServerSocket(port);
		while (true) {
			Socket socket = serverSocket.accept();
			/*Thread t = new Thread(new SocketThread(socket, table));
			t.start();
			
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
// Envío y recepción de información
			ObjectInputStream ois= new ObjectInputStream(is);
			System.out.println("Pedido generado con éxito");
			//Orderz pedido= (Orderz) ois.readObject();
			//table.addCell(pedido.getUser().toString());


			ois.close();
			is.close();
			os.close();
			socket.close();
			serverSocket.close();
			
						
			exportToPDF(response);
		
		}
	*/
		return "index";
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

	//@GetMapping("/export/pdf")
	public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=pedido.pdf";
		response.setHeader(headerKey, headerValue);

		// List<User> listUsers = service.listAll();

		PDFExporter exporter = new PDFExporter("Esto es una prueba");
		exporter.export(response);

	}
}
