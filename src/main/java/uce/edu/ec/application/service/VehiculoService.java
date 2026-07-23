package uce.edu.ec.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.Infraestructure.repository.VehiculoRepositoryImpl;
import uce.edu.ec.application.service.interceptors.Auditar;
import uce.edu.ec.domain.model.Vehiculo;

@ApplicationScoped
@Transactional
public class VehiculoService {
    @Inject
    private VehiculoRepositoryImpl impl;
    @Auditar
    public void guardar(Vehiculo vehiculo) {
        impl.persist(vehiculo);
    }

    public Vehiculo buscarPorId(Integer id) {
        return impl.findById(id);
    }
    @Auditar
    public void eliminarPorId(Integer id) {
        impl.deleteById(id);
    }
    @Auditar
    public Vehiculo buscarPorPlaca(String placa) {
        return impl.buscarVehiculoPorPLaca(placa);
    }
    @Auditar
    public void actualizarVehiculoPorPlaca(String placa, Vehiculo vehiculoActualizado) {
        Vehiculo vehiculoExistente = impl.buscarVehiculoPorPLaca(placa);
        if (vehiculoExistente != null) {
            vehiculoExistente.setMarca(vehiculoActualizado.getMarca());
            vehiculoExistente.setModelo(vehiculoActualizado.getModelo());
        }
    }

    
}
