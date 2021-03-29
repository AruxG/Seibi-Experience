package es.codeurjc.SeibiExperiencieServices.PDFService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

 
@Controller
public class PdfController {
 
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
 
}
