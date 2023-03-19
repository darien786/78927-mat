package mx.uv.practica03;

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
import https.t4is_uv_mx.saludos.SaludarRequest;

@Endpoint
public class EndPoint{

    protected String[] myArray = new String[10];


    public boolean estaVacia(String[] array, int indice){
        return array[indice] == null;
    }

    //saludar, buscar saludos, modificar saludo, borrar saludo
    @PayloadRoot(localPart = "SaludarRequest", namespace="https://t4is.uv.mx/saludos")
    @ResponsePayload 
    public SaludarResponse Saludar(@RequestPayload SaludarRequest peticion){
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
    public BuscarResponse Buscar(@RequestPayload BuscarRequest indice){
        BuscarResponse respuesta = new BuscarResponse();
        if(!estaVacia(myArray,indice.getIndice())){
            respuesta.setRespuesta("Hola " + myArray[indice.getIndice()].toString() + ", mucho gusto");
        }else if(estaVacia(myArray, 0)){
            respuesta.setRespuesta("La lista de saludos esta vacia");
        }else{
            respuesta.setRespuesta("No se encontro");    
        }
        return respuesta;
    }

    @PayloadRoot (localPart="ModificarRequest", namespace="https://t4is.uv.mx/saludos")
    @ResponsePayload
    public ModificarResponse Modificar(@RequestPayload ModificarRequest indice, @RequestPayload ModificarRequest peticion){
    ModificarResponse respuesta = new ModificarResponse();
    if(!estaVacia(myArray, indice.getIndice())){
        myArray[indice.getIndice()] = peticion.getNombre();
        respuesta.setRespuesta("Saludo Modificado");
    }else{
        respuesta.setRespuesta("No se encontro");
    }
    return respuesta;
    }
    
    @PayloadRoot (localPart="EliminarRequest", namespace="https://t4is.uv.mx/saludos")
    @ResponsePayload
    public EliminarResponse  Eliminar(@RequestPayload EliminarRequest indice){
        EliminarResponse respuesta = new EliminarResponse();
        if(!estaVacia(myArray, indice.getIndice())){
            myArray[indice.getIndice()] = null;
            respuesta.setRespuesta("Saludo eliminado");
        }

        return respuesta;
    }
}