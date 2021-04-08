package es.codeurjc.SeibiExperiencieServices.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;

import es.codeurjc.SeibiExperiencieServices.Services.PDFExporter;
import es.codeurjc.SeibiExperiencieSpring.model.Orderz;

@RestController
public class PDFController {

	@PostMapping("/pdf")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean pdf(@RequestBody Orderz orderz) throws DocumentException, IOException {
		PDFExporter exporter = new PDFExporter();
		exporter.export(orderz);
		return true;
	}
}
