package mx.uv.graphQL.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.uv.graphQL.Entitys.Categoria;

public interface CategoriaReposiroty extends JpaRepository<Categoria, Long>{
    
}
