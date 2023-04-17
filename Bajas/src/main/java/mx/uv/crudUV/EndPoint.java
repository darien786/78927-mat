package mx.uv.crudUV;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.escuela.BajasRequest;
import https.t4is_uv_mx.escuela.BajasResponse;

import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;




@Endpoint
public class EndPoint{
    
    @Autowired
    private IAsignaciones iAsignaciones;

    @PayloadRoot(localPart = "BajasRequest", namespace = "https://t4is.uv.mx/escuela")
    @ResponsePayload
    public BajasResponse altas(@RequestPayload BajasRequest request) {

        BajasResponse respuesta = new BajasResponse();
        Asignaciones asignar = new Asignaciones();

        if(iAsignaciones.findById(request.getIndex()).isPresent()){
            iAsignaciones.deleteById(request.getIndex());
            respuesta.setRespuesta("!Asignación eliminada con exito¡");
        }else{
            respuesta.setRespuesta("!La asiganción que se desea eliminar no existe¡");
        }
        return respuesta;
    }

}