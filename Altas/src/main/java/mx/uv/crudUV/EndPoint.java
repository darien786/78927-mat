package mx.uv.crudUV;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.escuela.AltasRequest;
import https.t4is_uv_mx.escuela.AltasResponse;

import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;




@Endpoint
public class EndPoint{
    
    @Autowired
    private IAsignaciones iAsignaciones;

    @PayloadRoot(localPart = "AltasRequest", namespace = "https://t4is.uv.mx/escuela")
    @ResponsePayload
    public AltasResponse altas(@RequestPayload AltasRequest request) {

        AltasResponse respuesta = new AltasResponse();
        Asignaciones asignar = new Asignaciones();
        asignar.setAlumno(request.getAlumno());
        asignar.setMaestro(request.getMaestro());
        asignar.setAula(request.getAula());

        iAsignaciones.save(asignar);

        respuesta.setRespuesta("!Asignación agregada con exito¡");
        return respuesta;
    }


}