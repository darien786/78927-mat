package mx.uv.demo;

public class Persona {
    String nombre;
    String apodo;
    Integer edad;

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setApodo(String apodo){
        this.apodo=apodo;
    }
       

    public String getNombre(){
        return nombre;
    }

    public String getApodo(){
        return apodo;
    }
}
