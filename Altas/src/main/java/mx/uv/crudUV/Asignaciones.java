package mx.uv.crudUV;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Asignaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private String Alumno;
    private String Maestro;
    private String Aula;

    public void setId(Integer id){
        this.id=id;
    }

    public Integer getId(){
        return id;
    }

    public void setAlumno(String alumno){
        this.Alumno = alumno;
    }    

    public void setMaestro(String maestro){
        this.Maestro = maestro;
    }

    public void setAula(String aula){
        this.Aula = aula;
    }

    public String getAlumno(){
        return Alumno;
    }

    public String getMaestro(){
        return Maestro;
    }

    public String getAula(){
        return Aula;
    }
    
}
