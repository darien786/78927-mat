package mx.uv.graphQL.Web;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import mx.uv.graphQL.Entitys.Categoria;
import mx.uv.graphQL.Entitys.Producto;
import mx.uv.graphQL.Repository.CategoriaReposiroty;
import mx.uv.graphQL.Repository.ProductoRepository;
import mx.uv.graphQL.dto.ProductoRequest;


@Controller
public class ProductoGraphQLController {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaReposiroty categoriaReposiroty;

    @QueryMapping
    public List<Producto> listarProductos(){
        return productoRepository.findAll();
    }

    @QueryMapping
    public Producto listarProductoPorId(@Argument String id){
        return productoRepository.findById(id).orElseThrow(
            ()-> new RuntimeException(String.format("Producto %s no encontrado",id))
        );
    }

    @QueryMapping
    public List<Categoria> listarCategorias(){
        return categoriaReposiroty.findAll();
    }


    @QueryMapping
    public Categoria listarCategoriaPorId(@Argument Long id){
        return categoriaReposiroty.findById(id).orElseThrow(
            ()-> new RuntimeException(String.format("Categoria %s no encontrado",id))
        );
    }

    @MutationMapping
    public Producto guardarProducto(@Argument ProductoRequest productoRequest ) {
        Categoria categoria = categoriaReposiroty.findById(productoRequest.categoriaId()).orElse(null);
        Producto productoBBDD = new Producto();
        productoBBDD.setId(UUID.randomUUID().toString());
        productoBBDD.setNombre(productoRequest.nombre());
        productoBBDD.setPrecio(productoRequest.precio());
        productoBBDD.setCantidad(productoRequest.cantidad());
        productoBBDD.setCategoria(categoria);

        return productoRepository.save(productoBBDD);

    }


    @MutationMapping
    public Producto actualizarProducto(@Argument String id, @Argument ProductoRequest productoRequest ) {
        Categoria categoria = categoriaReposiroty.findById(productoRequest.categoriaId()).orElse(null);
        Producto productoBBDD = new Producto();
        productoBBDD.setId(id);
        productoBBDD.setNombre(productoRequest.nombre());
        productoBBDD.setPrecio(productoRequest.precio());
        productoBBDD.setCantidad(productoRequest.cantidad());
        productoBBDD.setCategoria(categoria);

        return productoRepository.save(productoBBDD);

    }

    @MutationMapping
    public void eliminarProducto(@Argument String id) {
        productoRepository.deleteById(id);
    }
}
