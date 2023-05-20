package mx.uv.graphQL.dto;

public record ProductoRequest(
    String id,
    String nombre,
    Float precio,
    int cantidad,
    Long categoriaId
) {
    
}
