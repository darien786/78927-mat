package mx.uv.graphQL;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import mx.uv.graphQL.Entitys.Categoria;
import mx.uv.graphQL.Entitys.Producto;
import mx.uv.graphQL.Repository.CategoriaReposiroty;
import mx.uv.graphQL.Repository.ProductoRepository;

@SpringBootApplication
public class GraphQlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphQlApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(CategoriaReposiroty categoriaRepository, ProductoRepository productoRepository){
		Random random = new Random();
		return args -> {
			List.of("Computadoras", "Impresoras", "Smartphones").forEach(cat->{
				Categoria categoria = Categoria.builder().nombre(cat).build();
				categoriaRepository.save(categoria);
			});
			categoriaRepository.findAll().forEach(categoria->{
				for(int i=0;i<10;i++){
					Producto producto = Producto.builder()
						.id(UUID.randomUUID().toString())
						.nombre("Computadora"+i)
						.precio(100 + Math.random()*5000)
						.cantidad(random.nextInt(100))
						.categoria(categoria)
						.build();
					productoRepository.save(producto);
				}
			});
		}; 
	}

}
