package uce.edu.ec.web.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import uce.edu.ec.application.service.CiudadanoService;

@Path("/ciudadano")
public class CiudadanoResource {
    @Inject
    private CiudadanoService ciudadanoService;
    @Path("/leerArchivo/{ruta}")
    @POST
    public void leerArchivo(@PathParam("ruta") String ruta) {
        try {
            ciudadanoService.leerRutaDeArchivo(ruta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
