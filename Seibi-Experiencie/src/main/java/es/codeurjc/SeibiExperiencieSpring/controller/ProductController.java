package es.codeurjc.SeibiExperiencieSpring.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import es.codeurjc.SeibiExperiencieSpring.model.Product;
import es.codeurjc.SeibiExperiencieSpring.model.User;
import es.codeurjc.SeibiExperiencieSpring.repository.OrderzRepository;
import es.codeurjc.SeibiExperiencieSpring.repository.ProductRepository;
import es.codeurjc.SeibiExperiencieSpring.repository.UserRepository;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.mock.web.MockMultipartFile;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository products;
	
	@Autowired
	private OrderzRepository orders;
	
	@Autowired
	private UserRepository users;
	
	public Blob getMultipartFile(String path) throws IOException {
		File file = null;
		try {
			   file = new ClassPathResource(path).getFile();    
			} catch (IOException e) {

			}
		FileInputStream input = new FileInputStream(file);
		MultipartFile image = new MockMultipartFile("file",file.getName(), "image/png", IOUtils.toByteArray(input));
	    byte[] bytes;
	    Blob imagen = null;
        if (image != null) {
            try {

                bytes = image.getBytes();
                imagen = new javax.sql.rowset.serial.SerialBlob(bytes);
            }
            catch (Exception exc){
                return null;
            }
        }
        return imagen;
	}
	@PostConstruct
	public void init() throws IOException {
		if(products.findAll().size()==0) {
			//Madrid experiences
			String activities = "Desayuno, Museo del prado, Aperitivo";
			Blob imagen = getMultipartFile("static/images/madridbymorning.png");
			products.save(new Product("MadridByMorning", activities,"Madrid","Mañana",imagen,"Ideal para conocer Madrid",50));
			
			activities = "Almuerzo en terraza con vistas a la ciudad, Escape Room Lever, Merienda";
			imagen = getMultipartFile("static/images/madridbyevening.png");
			products.save(new Product("MadridByEvening", activities,"Madrid","Tarde",imagen,"Vas a adorar Madrid",70));
			
			activities = "Rocódromo, Cena, ver El rey León";
			imagen = getMultipartFile("static/images/madridbynight.png");
			products.save(new Product("MadridByNight", activities,"Madrid","Noche",imagen,"Una noche de fantasía en Madrid",50));
			
			//Barcelona experiences
			activities = "Desayuno, visitar Sagrada Familia";
			imagen = getMultipartFile("static/images/barcelonabymorning.png");
			products.save(new Product("BarcelonaByMorning", activities,"Barcelona","Mañana",imagen,"Ideal para conocer Barcelona",40));
			
			activities = "Almuerzo en una terraza con vistas a la ciudad, visitar Parque Güell, merienda";
			imagen = getMultipartFile("static/images/barcelonabyevening.png");
			products.save(new Product("BarcelonaByEvening", activities,"Barcelona","Tarde",imagen,"Vas a adorar Barcelona",30));
			
			activities = "Cena en un yate con vistas al mar y música en directo de la mano de Sailing Experience";
			imagen = getMultipartFile("static/images/barcelonabynight.png");
			products.save(new Product("BarcelonaByNight", activities,"Barcelona","Noche",imagen,"Una noche de fantasía en Barcelona",60));
			
			//Toledo experiences
			activities = "Desayuno, Visita guiada por los monumentos más importantes de Toledo";
			imagen = getMultipartFile("static/images/toledobymorning.png");
			products.save(new Product("ToledoByMorning", activities,"Toledo","Mañana",imagen,"Ideal para conocer Toledo",30));
			
			activities = "Almuerzo, circuito de spa con masaje incluido y merienda temática";
			imagen = getMultipartFile("static/images/toledobyevening.png");
			products.save(new Product("ToledoByEvening", activities,"Toledo","Tarde",imagen,"Vas a adorar Toledo",45));
			
			activities = "Cena en hotel burbuja contemplando las estrellas";
			imagen = getMultipartFile("static/images/toledobynight.png");
			products.save(new Product("ToledoByNight", activities,"Toledo","Noche",imagen,"Una noche de fantasía en Toledo",50));
			
			//Sevilla experiences
			activities = "Desayuno, visita guiada por el casco antiguo de Sevilla";
			imagen = getMultipartFile("static/images/sevillabymorning.png");
			products.save(new Product("SevillaByMorning", activities,"Sevilla","Mañana",imagen,"Ideal para conocer Sevilla",60));
			
			activities = "Almuerzo con vistas al río Guadalquivir, kayak por el río";
			imagen = getMultipartFile("static/images/sevillabyevening.png");
			products.save(new Product("SevillaByEvening", activities,"Sevilla","Tarde",imagen,"Vas a adorar Sevilla",80));
			
			activities = "Cena en Tablao Flamenco con espectáculo";
			imagen = getMultipartFile("static/images/sevillabynight.png");
			products.save(new Product("SevillaByNight", activities,"Sevilla","Noche",imagen,"Una noche de fantasía en Sevilla",30));
			
			//Pontevedra experiences
			activities = "Desayuno, visita a enoteca con cata";
			imagen = getMultipartFile("static/images/pontevedrabymorning.png");
			products.save(new Product("PontevedraByMorning", activities,"Pontevedra","Mañana",imagen,"Ideal para conocer Pontevedra",40));
			
			activities = "Almuerzo con mariscada, clase de surf";
			imagen = getMultipartFile("static/images/pontevedrabyevening.png");
			products.save(new Product("PontevedraByEvening", activities,"Pontevedra","Tarde",imagen,"Vas a adorar Pontevedra",50));
			
			activities = "Noche en hórreos con cena incluida";
			imagen = getMultipartFile("static/images/pontevedrabynight.png");
			products.save(new Product("PontevedraByNight", activities,"Pontevedra","Noche",imagen,"Una noche de fantasía en Pontevedra",60));
		}
		

	}
	@GetMapping("/private")
	public String privatePage(Model model, HttpServletRequest request) {

		String name = request.getUserPrincipal().getName();
		
		User user = users.findByName(name);

		model.addAttribute("username", user.getName());		
		model.addAttribute("admin", request.isUserInRole("ADMIN"));

		return "private";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	@GetMapping("/")
	public String showPosts(Model model, HttpSession session,@PageableDefault(size = 5) Pageable page) {
		Page<Product> prod = products.findAll(page);
		
		model.addAttribute("products", prod);
		model.addAttribute("hasPrev", prod.hasPrevious());
		model.addAttribute("hasNext", prod.hasNext());
		model.addAttribute("nextPage", prod.getNumber()+1);
		model.addAttribute("prevPage", prod.getNumber()-1);		
		
		model.addAttribute("welcome", session.isNew());
		model.addAttribute("user",session.getValue("user"));
		model.addAttribute("ciudad", "Any");
		model.addAttribute("hora", "Any");
		return "index";
	}
	@PostMapping("/")
	public String showPostsFiltered(
			Model model, 
			HttpSession session, 
			@PageableDefault(size = 5) Pageable page, 
			@RequestParam String city, 
			@RequestParam String time) 
	{
		Page<Product> productsFiltered;
		if(!city.equals("Any") && !time.equals("Any")) {
			productsFiltered= products.findByCityAndTime(city, time, page);
		}else if(!city.equals("Any")) {
			productsFiltered= products.findByCity(city, page);
		}else if(!time.equals("Any")){
			productsFiltered= products.findByTime(time, page);
		}else {
			productsFiltered= products.findAll(page);
		}
		
		model.addAttribute("products", productsFiltered);
		model.addAttribute("hasPrev", productsFiltered.hasPrevious());
		model.addAttribute("hasNext", productsFiltered.hasNext());
		model.addAttribute("nextPage", productsFiltered.getNumber()+1);
		model.addAttribute("prevPage", productsFiltered.getNumber()-1);	
		model.addAttribute("user",session.getValue("user"));
		model.addAttribute("ciudad", city);
		model.addAttribute("hora", time);
		return "index";
	}
	@GetMapping("/products/{id}")
	public String showPost(Model model,HttpSession httpSession, @PathVariable long id) throws SQLException {
		User user=null;
		if (httpSession.getAttribute("user")!=null){
			user = users.findByName((httpSession.getAttribute("user")).toString());
		}
		Product product = products.findById(id).orElseThrow();
		if(user!=null) {
			if(user.containsProduct(product)) {
				model.addAttribute("Carrito", true);
			}
		}
		model.addAttribute("imagen", null);
		Blob foto = product.getImage();
		if(foto != null) {
			if(foto.length() > 1 ) {
	            byte[] bdata = foto.getBytes(1, (int) foto.length());
	            String s = java.util.Base64.getEncoder().encodeToString(bdata);
	            model.addAttribute("imagen", s);
	        }
		}
		model.addAttribute("product", product);
		model.addAttribute("user", httpSession.getValue("user"));
		model.addAttribute("usersession",httpSession.getAttribute("user"));
		return "show_product";
	}
	@PostMapping("/products/{id}")
	public String deletePost(Model model, HttpSession httpSession, @RequestParam Long id_producto) throws SQLException {
		User user = users.findByName((httpSession.getAttribute("user")).toString());
		Product product = products.findById(id_producto).orElseThrow();
		user.removeProduct(product);
		users.save(user);
		if(user!=null) {
			if(user.containsProduct(product)) {
				model.addAttribute("Carrito", true);
			}
		}
		model.addAttribute("imagen", null);
		Blob foto = product.getImage();
		if(foto != null) {
			if(foto.length() > 1 ) {
	            byte[] bdata = foto.getBytes(1, (int) foto.length());
	            String s = java.util.Base64.getEncoder().encodeToString(bdata);
	            model.addAttribute("imagen", s);
	        }
		}
		model.addAttribute("product", product);
		model.addAttribute("user", httpSession.getValue("user"));
		model.addAttribute("usersession",httpSession.getAttribute("user"));
		return "show_product";
	}

	@GetMapping("/products/{id}/buy")
	public String buyProduct(Model model,HttpSession httpSession, @PathVariable long id) {
		Product product = products.findById(id).orElseThrow();
		User user = users.findByName((httpSession.getAttribute("user")).toString());
		user.addProduct(product);
		users.save(user);
		model.addAttribute("product", product);
		model.addAttribute("user", httpSession.getValue("user"));
		return "product_cart";
	}

	
	@PostMapping("/subirFoto")
	public String subirFoto(Model model, HttpSession httpSession, @RequestParam MultipartFile image, @RequestParam Long id_producto) {
		Product product = products.findById(id_producto).orElseThrow();
		byte[] bytes;

        if (image != null) {
            try {
                // Por si se quiere guardar tambien el nombre y el tamaño de la imagen
                String nombreFoto = image.getOriginalFilename();
                long tamañoFoto = image.getSize();

                bytes = image.getBytes();

                //String formatName = nombreFoto.substring(nombreFoto.lastIndexOf(".") + 1);
                //bytes = imageServ.resize(bytes, 200, 200, formatName);

                Blob imagen = new javax.sql.rowset.serial.SerialBlob(bytes);

                String bphoto = java.util.Base64.getEncoder().encodeToString(bytes);

                product.setImage(imagen);
                products.save(product);
            }
            catch (Exception exc){
                return "Fallo al establecer la imagen de perfil";
            }
        }
        return "subirFoto";
	}
}