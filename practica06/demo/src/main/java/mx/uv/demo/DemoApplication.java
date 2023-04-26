package mx.uv.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@RequestMapping("/")
	public String name1() {
		return "Hola mundo";
	}

	@RequestMapping("/adios")
	public String name2() {
		return "adios mundo";
	}

	@RequestMapping("/pregunta")
	public String name3() {
		return "como estas?";
	}

	@RequestMapping("/productos")
	public List<String> productos() {
		List<String> p = new ArrayList<String>();
		p.add("pambazos");
		p.add("tamales");
		p.add("refrescos");
		return p;
	}

	@RequestMapping("/productos2")
	public List<Productos> productos2() {
		List<Productos> lista = new ArrayList<Productos>();
		Productos p = new Productos("pambazos", 10);
		lista.add(p);
		Productos p1 = new Productos("tamales", 12);
		lista.add(p1);
		Productos p2 = new Productos("refrescos", 15);
		lista.add(p2);

		return lista;
	}

	//curl -i loclahost 8080
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String saludarGet() {
		return "mensaje de tipo get";
	}

	@RequestMapping(value ="post", method = RequestMethod.POST)
	public String saludarPost() {
		return "mensaje de tipo post";
	}

}
