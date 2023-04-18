package mx.uv.crudUV;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.escuela.MostrarResponse;

import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;




@Endpoint
public class EndPoint{
    
    @Autowired
    private IAsignaciones iAsignaciones;

    @PayloadRoot (localPart = "MostrarRequest", namespace = "https://t4is.uv.mx/escuela")
    @ResponsePayload
    public MostrarResponse Mostrar(){
        MostrarResponse mostrar = new MostrarResponse();
        List<Asignaciones> asignaciones = (List<Asignaciones>) iAsignaciones.findAll();
        String cadena = "";
        for (Asignaciones asignacion : asignaciones){
            cadena += "ID: " + asignacion.getId().toString() + "\nALUMNO: " + asignacion.getAlumno().toString() + "\nMAESTRO: " + asignacion.getMaestro().toString() + "\nAULA: " + asignacion.getAula().toString() + "\n";
            
            mostrar.setRespuesta(cadena);
        }
        
        return mostrar;
    }
}