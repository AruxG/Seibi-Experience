package es.codeurjc.SeibiExperiencieServices.PDFService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
 
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
 
import com.lowagie.text.DocumentException;
 
@Controller
public class PdfController {
 
	@GetMapping("/")
	public String index() {
		return "index";
	}
	 @RequestMapping(value = "/generate/pdf.htm", method = RequestMethod.GET)
	 ModelAndView generatePdf(HttpServletRequest request,
	   HttpServletResponse response) throws Exception {
	  System.out.println("Calling generatePdf()...");
	  
	  Order pedido = null;
	  
	  ModelAndView modelAndView = new ModelAndView("pdfView", "command",pedido);
	  //https://www.technicalkeeda.com/spring-tutorials/generate-pdf-using-spring-framework
	  //URL con info↑
	  return modelAndView;
	 }
 
 
 @GetMapping("/export/pdf")
 public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
     response.setContentType("application/pdf");
     DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
     String currentDateTime = dateFormatter.format(new Date());
      
     String headerKey = "Content-Disposition";
     String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
     response.setHeader(headerKey, headerValue);
      
     //List<User> listUsers = service.listAll();
      
     PDFExporter exporter = new PDFExporter("Esto es una prueba");
     exporter.export(response);
      
 }
}
