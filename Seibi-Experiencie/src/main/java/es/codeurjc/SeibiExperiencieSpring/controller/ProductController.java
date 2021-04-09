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
			//Blob imagen = getMultipartFile("static/images/madridbymorning.png");
			Blob imagen = null;
			products.save(new Product("MadridByMorning", activities,"Madrid","Mañana",imagen,"Ideal para conocer Madrid",50));
			
			activities = "Almuerzo en terraza con vistas a la ciudad, Escape Room Lever, Merienda";
			//imagen = getMultipartFile("static/images/madridbyevening.png");
			products.save(new Product("MadridByEvening", activities,"Madrid","Tarde",imagen,"Vas a adorar Madrid",70));
			
			
			activities = "Rocódromo, Cena, ver El rey León";
			//imagen = getMultipartFile("static/images/madridbynight.png");
			products.save(new Product("MadridByNight", activities,"Madrid","Noche",imagen,"Una noche de fantasía en Madrid",50));
			
			//Barcelona experiences
			activities = "Desayuno, visitar Sagrada Familia";
			//imagen = getMultipartFile("static/images/barcelonabymorning.png");
			products.save(new Product("BarcelonaByMorning", activities,"Barcelona","Mañana",imagen,"Ideal para conocer Barcelona",40));
			
			activities = "Almuerzo en una terraza con vistas a la ciudad, visitar Parque Güell, merienda";
			imagen = getMultipartFile("static/images/barcelonabyevening.png");
			products.save(new Product("BarcelonaByEvening", activities,"Barcelona","Tarde",imagen,"Vas a adorar Barcelona",30));
			
			activities = "Cena en un yate con vistas al mar y música en directo de la mano de Sailing Experience";
			//imagen = getMultipartFile("static/images/barcelonabynight.png");
			products.save(new Product("BarcelonaByNight", activities,"Barcelona","Noche",imagen,"Una noche de fantasía en Barcelona",60));
			
			//Toledo experiences
			activities = "Desayuno, Visita guiada por los monumentos más importantes de Toledo";
			//imagen = getMultipartFile("static/images/toledobymorning.png");
			products.save(new Product("ToledoByMorning", activities,"Toledo","Mañana",imagen,"Ideal para conocer Toledo",30));
			
			activities = "Almuerzo, circuito de spa con masaje incluido y merienda temática";
			//imagen = getMultipartFile("static/images/toledobyevening.png");
			products.save(new Product("ToledoByEvening", activities,"Toledo","Tarde",imagen,"Vas a adorar Toledo",45));
			
			activities = "Cena en hotel burbuja contemplando las estrellas";
			//imagen = getMultipartFile("static/images/toledobynight.png");
			products.save(new Product("ToledoByNight", activities,"Toledo","Noche",imagen,"Una noche de fantasía en Toledo",50));
			
			//Sevilla experiences
			activities = "Desayuno, visita guiada por el casco antiguo de Sevilla";
			//imagen = getMultipartFile("static/images/sevillabymorning.png");
			products.save(new Product("SevillaByMorning", activities,"Sevilla","Mañana",imagen,"Ideal para conocer Sevilla",60));
			
			activities = "Almuerzo con vistas al río Guadalquivir, kayak por el río";
			//imagen = getMultipartFile("static/images/sevillabyevening.png");
			products.save(new Product("SevillaByEvening", activities,"Sevilla","Tarde",imagen,"Vas a adorar Sevilla",80));
			
			activities = "Cena en Tablao Flamenco con espectáculo";
			//imagen = getMultipartFile("static/images/sevillabynight.png");
			products.save(new Product("SevillaByNight", activities,"Sevilla","Noche",imagen,"Una noche de fantasía en Sevilla",30));
			
			//Pontevedra experiences
			activities = "Desayuno, visita a enoteca con cata";
			//imagen = getMultipartFile("static/images/pontevedrabymorning.png");
			products.save(new Product("PontevedraByMorning", activities,"Pontevedra","Mañana",imagen,"Ideal para conocer Pontevedra",40));
			
			activities = "Almuerzo con mariscada, clase de surf";
			//imagen = getMultipartFile("static/images/pontevedrabyevening.png");
			products.save(new Product("PontevedraByEvening", activities,"Pontevedra","Tarde",imagen,"Vas a adorar Pontevedra",50));
			
			activities = "Noche en hórreos con cena incluida";
			//imagen = getMultipartFile("static/images/pontevedrabynight.png");
			products.save(new Product("PontevedraByNight", activities,"Pontevedra","Noche",imagen,"Una noche de fantasía en Pontevedra",60));
		
		}
		

	}

	
	@GetMapping("/")
	public String showPosts(Model model, HttpSession session,HttpServletRequest request,@PageableDefault(size = 5) Pageable page) {
		if(request.getUserPrincipal()!=null) {
			String name = request.getUserPrincipal().getName();
			
			User user = users.findByName(name).orElseThrow();
			if (user != null) {
				model.addAttribute("usernombre", user.getName());		
				model.addAttribute("user",user.getName());
				model.addAttribute("admin", request.isUserInRole("ADMIN"));
			}
		}
		Page<Product> prod = products.findAll(page);
		
		model.addAttribute("products", prod);
		model.addAttribute("hasPrev", prod.hasPrevious());
		model.addAttribute("hasNext", prod.hasNext());
		model.addAttribute("nextPage", prod.getNumber()+1);
		model.addAttribute("prevPage", prod.getNumber()-1);		
		
		model.addAttribute("welcome", session.isNew());
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
			@RequestParam String time,
			HttpServletRequest request) 
	{
		if(request.getUserPrincipal()!=null) {
			String name = request.getUserPrincipal().getName();
			
			User user = users.findByName(name).orElseThrow();
			if (user != null) {
				model.addAttribute("usernombre", user.getName());		
				model.addAttribute("user",user.getName());
				model.addAttribute("admin", request.isUserInRole("ADMIN"));
			}
		}
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
		model.addAttribute("ciudad", city);
		model.addAttribute("hora", time);
		return "index";
	}
	@GetMapping("/products/{id}")
	public String showPost(Model model,HttpSession httpSession,HttpServletRequest request, @PathVariable long id) throws SQLException {
		User user = null;
		if(request.getUserPrincipal()!=null) {
			String name = request.getUserPrincipal().getName();
			user = users.findByName(name).orElseThrow();
			model.addAttribute("usernombre", user.getName());		
			model.addAttribute("user",user.getName());
			model.addAttribute("admin", request.isUserInRole("ADMIN"));
			model.addAttribute("usersession",user.getName());
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
		return "show_product";
	}
	
	@PostMapping("/products/{id}")
	public String deleteProduct(Model model,HttpServletRequest request, @RequestParam Long id) throws SQLException {
		User user = null;
		if(request.getUserPrincipal()!=null) {
			String name = request.getUserPrincipal().getName();
			user = users.findByName(name).orElseThrow();
			model.addAttribute("usernombre", user.getName());		
			model.addAttribute("user",user.getName());
			model.addAttribute("admin", request.isUserInRole("ADMIN"));
			model.addAttribute("usersession",user.getName());
		}
		
		Product product = products.findById(id).orElseThrow();
		
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
		return "show_product";
	}

	@GetMapping("/products/{id}/buy")
	public String buyProduct(Model model, @PathVariable long id,HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		
		User user = users.findByName(name).orElseThrow();

		model.addAttribute("usernombre", user.getName());		
		model.addAttribute("user", user.getName());		
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		
		Product product = products.findById(id).orElseThrow();
		user.addProduct(product);
		users.save(user);
		model.addAttribute("product", product);
		return "product_cart";
	}

	@GetMapping("/admin")
	public String anadirProducto(Model model,HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		
		User user = users.findByName(name).orElseThrow();

		model.addAttribute("usernombre", user.getName());		
		model.addAttribute("user", user.getName());		
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		return "insert_product";
	}
	
	@PostMapping("/admin/addProduct")
	public String productoAnadido(Model model, HttpServletRequest request,
			@RequestParam String name,@RequestParam String city, @RequestParam String time,
			@RequestParam String activities, @RequestParam String description,@RequestParam int price,
			@RequestParam MultipartFile image) {
		String nameuser = request.getUserPrincipal().getName();
		
		User user = users.findByName(nameuser).orElseThrow();

		model.addAttribute("usernombre", user.getName());		
		model.addAttribute("user", user.getName());		
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		if(!name.equals("") && !activities.equals("") && !description.equals("") && price>0) {
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
	                Product product = new Product(name,activities,city,time,imagen,description,price);
	                products.save(product);
	            }
	            catch (Exception exc){
	                return "Fallo al establecer la imagen de perfil";
	            }
	        }else {
	        	Product product = new Product(name,activities,city,time,null,description,price);
	        	products.save(product);
	        }
	        
	        return "product_added";
		}else {
			model.addAttribute("errorcampos", true);
			return "insert_product";
		}
		
		
	}
	/*
	@GetMapping("/products/{id}/delete_product")
	public String deleteProduct(Model model,@PathVariable Long id, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		
		User user = users.findByName(name).orElseThrow();

		model.addAttribute("username", user.getName());		
		model.addAttribute("user", user.getName());		
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		Product product = products.findById(id).orElseThrow();
		products.delete(product);
		return "delete_product";
	}
	*/
	@PostMapping("/subirFoto")
	public String subirFoto(Model model, @RequestParam MultipartFile image, @RequestParam Long id_producto,HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		
		User user = users.findByName(name).orElseThrow();

		model.addAttribute("usernombre", user.getName());		
		model.addAttribute("user", user.getName());		
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
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
            return "subirFoto";
        }else {
        	model.addAttribute("product", product);
        	return "show_product";
        }
       
	}
}