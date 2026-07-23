package uce.edu.ec.web.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import uce.edu.ec.application.service.VehiculoService;
import uce.edu.ec.domain.model.Vehiculo;

@Path("/vehiculo")
public class VehiculoResource {
    @Inject
    private VehiculoService vehiculoService;
    @Path("/guardar")
    @POST
    public void guardarVehiculo(Vehiculo vehiculo) {
        vehiculoService.guardar(vehiculo);
    }
    @Path("/buscar/{id}")
    @GET
    public Vehiculo buscarVehiculoPorId(@PathParam("id") Integer id) {
        return vehiculoService.buscarPorId(id);
    }

    @Path("/buscarporplaca/{placa}")
    @GET
    public Vehiculo buscarVehiculoPorPlaca(@PathParam("placa") String placa) {
        return vehiculoService.buscarPorPlaca(placa);
    }
    @Path("/actualizarporplaca/{placa}")
    @PUT
    public void actualizarVehiculoPorPlaca(@PathParam("placa") String placa, Vehiculo vehiculoActualizado) {
        vehiculoService.actualizarVehiculoPorPlaca(placa, vehiculoActualizado);
    }
}
