package mx.uv.practica03;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

import https.t4is_uv_mx.saludos.SaludarResponse;
import https.t4is_uv_mx.saludos.SaludarRequest;

@Endpoint
public class EndPoint{
    //saludar, buscar saludos, modificar saludo, borrar saludo
    @PayloadRoot(localPart = "SaludarRequest", namespace="https://t4is.uv.mx/saludos")
    @ResponsePayload 
    public SaludarResponse Saludar(@RequestPayload SaludarRequest peticion){
        SaludarResponse respuesta = new SaludarResponse();
        respuesta.setRespuesta("Hola " + peticion.getNombre());
        return respuesta;
    }
    
}