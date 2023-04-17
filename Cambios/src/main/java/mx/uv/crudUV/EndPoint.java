package mx.uv.crudUV;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.escuela.ModificarRequest;
import https.t4is_uv_mx.escuela.ModificarResponse;

import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;




@Endpoint
public class EndPoint{
    
    @Autowired
    private IAsignaciones iAsignaciones;

    @PayloadRoot(localPart = "ModificarRequest", namespace = "https://t4is.uv.mx/escuela")
    @ResponsePayload
    public ModificarResponse altas(@RequestPayload ModificarRequest request) {

        ModificarResponse respuesta = new ModificarResponse();
        Asignaciones asignar = new Asignaciones();

        if(iAsignaciones.findById(request.getIndex()).isPresent()){
            asignar.setId(request.getIndex());
            asignar.setAlumno(request.getNuevoAlumno());
            asignar.setMaestro(request.getNuevoMaestro());
            asignar.setAula(request.getNuevaAula());
            iAsignaciones.save(asignar);
            
        respuesta.setRespuesta("!Asignación modificada con exito¡");
        }else{
            
        respuesta.setRespuesta("!Error¡");
        }
        return respuesta;
    }

}