package mx.uv.practica04;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

import https.t4is_uv_mx.saludos.SaludarResponse;
import https.t4is_uv_mx.saludos.BuscarRequest;
import https.t4is_uv_mx.saludos.BuscarResponse;
import https.t4is_uv_mx.saludos.EliminarRequest;
import https.t4is_uv_mx.saludos.EliminarResponse;
import https.t4is_uv_mx.saludos.ModificarRequest;
import https.t4is_uv_mx.saludos.ModificarResponse;
import https.t4is_uv_mx.saludos.MostrarResponse;
import https.t4is_uv_mx.saludos.SaludarRequest;

@Endpoint
public class EndPoint{
    
    @Autowired
    private ISaludador iSaludador;
    protected String[] myArray = new String[10];

    public boolean estaVacia(String[] array, int posicion){
    return array[posicion] == null;
     }

    //saludar, buscar saludos, modificar saludo, borrar saludo
    @PayloadRoot(localPart = "SaludarRequest", namespace="https://t4is.uv.mx/saludos")
    @ResponsePayload 
    public SaludarResponse Saludar(@RequestPayload SaludarRequest peticion){
        //persistencia a la base de datos
        Saludador saludador = new Saludador();
        saludador.setNombre(peticion.getNombre());
        //meter a la base de datos
        iSaludador.save(saludador);
        
        
        SaludarResponse respuesta = new SaludarResponse();
         for(int i=0; i<myArray.length;i++){
             if(estaVacia(myArray, i)){
                 myArray[i] = peticion.getNombre();
                 break;
             }
         }
        
        respuesta.setRespuesta("Hola " + peticion.getNombre() + ", mucho gusto");
        return respuesta;
    }
    
    @PayloadRoot (localPart="BuscarRequest", namespace="https://t4is.uv.mx/saludos")
    @ResponsePayload
    public BuscarResponse Buscar(@RequestPayload BuscarRequest posicion){
        BuscarResponse respuesta = new BuscarResponse();
        // if(!estaVacia(myArray,posicion.getPosicion())){
        //     respuesta.setRespuesta("Hola " + myArray[posicion.getPosicion()].toString() + ", mucho gusto");
        // }else{
        //     respuesta.setRespuesta("No se encontro");    
        // }

        if(!iSaludador.findById(posicion.getPosicion()).isEmpty()){
            respuesta.setRespuesta("Hola " + iSaludador.findById(posicion.getPosicion()).get().getNombre() + ", mucho gusto");
        }else{
            respuesta.setRespuesta("No se encontro");
        }
        
        return respuesta;
    }

    @PayloadRoot (localPart="ModificarRequest", namespace="https://t4is.uv.mx/saludos")
    @ResponsePayload
    public ModificarResponse Modificar(@RequestPayload ModificarRequest posicion, @RequestPayload ModificarRequest peticion){
    ModificarResponse respuesta = new ModificarResponse();
    Saludador saludador = new Saludador();
    // if(!estaVacia(myArray, posicion.getPosicion())){
    //     myArray[posicion.getPosicion()] = peticion.getNombre();
    //     respuesta.setRespuesta("Saludo Modificado");
    // }else{
    //     respuesta.setRespuesta("No se encontro");
    // }
    
    if(!iSaludador.findById(posicion.getPosicion()).isEmpty()){
        saludador.setId(posicion.getPosicion());
        saludador.setNombre(peticion.getNombre());
        iSaludador.save(saludador);

        respuesta.setRespuesta("Nombre modificado a: " + saludador.getNombre());
    
    }else{
        respuesta.setRespuesta("No se encontro");
    }
    return respuesta;
    }
    
    @PayloadRoot (localPart="EliminarRequest", namespace="https://t4is.uv.mx/saludos")
    @ResponsePayload
    public EliminarResponse  Eliminar(@RequestPayload EliminarRequest posicion){
        EliminarResponse respuesta = new EliminarResponse();
        // if(!estaVacia(myArray, posicion.getPosicion())){
        //     myArray[posicion.getPosicion()] = null;
        //     respuesta.setRespuesta("Saludo eliminado");
        // }

        if(!iSaludador.findById(posicion.getPosicion()).isEmpty()){
            iSaludador.deleteById(posicion.getPosicion());
            respuesta.setRespuesta("Saludo eliminado");
        }else{
            respuesta.setRespuesta("No se encontro");
        }
        return respuesta;
    }

    @PayloadRoot (localPart="MostrarRequest", namespace="https://t4is.uv.mx/saludos")
    @ResponsePayload
    public MostrarResponse Mostrar(){
        MostrarResponse mostrar = new MostrarResponse();
        String cadena = "";
        List<Saludador> saludados = (List<Saludador>) iSaludador.findAll();
        for(Saludador saludo : saludados){
            
            cadena += "ID: "+ saludo.getId().toString()+ ", NOMBRE: " + saludo.getNombre().toString() + ", ";
            
            mostrar.setRespuesta(cadena);
        }

        return mostrar;
    }


}