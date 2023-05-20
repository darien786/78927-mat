package mx.uv.graphQL.Entitys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Producto {
    
    @Id
    private String id;
    private String nombre;
    private double precio;
    private int cantidad;

    @ManyToOne
    private Categoria categoria;
}
