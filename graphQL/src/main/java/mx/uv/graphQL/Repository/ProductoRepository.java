package mx.uv.graphQL.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.uv.graphQL.Entitys.Producto;

public interface ProductoRepository extends JpaRepository<Producto, String>{
    
}
