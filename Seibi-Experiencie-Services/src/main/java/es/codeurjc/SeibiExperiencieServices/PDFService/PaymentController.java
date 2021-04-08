package es.codeurjc.SeibiExperiencieServices.PDFService;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
public class PaymentController {

	@PostMapping(value="/payment")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean payment(@RequestBody List<String> datos) {
		if ((!datos.get(0).equals("") && (datos.get(0).endsWith("@gmail.com") || datos.get(0).endsWith("@gmail.es")
				|| datos.get(0).endsWith("@hotmail.com") || datos.get(0).endsWith("@hotmail.es")))
				&& (Integer.parseInt(datos.get(1)) >= 10000000 && Integer.parseInt(datos.get(1)) <= 99999999) && (Integer.parseInt(datos.get(2)) >= 100 && Integer.parseInt(datos.get(2)) <= 999)) {
			System.out.println("TRUE");
			return true;
			
		}else {
			System.out.println("FALSE");
			return false;
		}

	}
	
}
