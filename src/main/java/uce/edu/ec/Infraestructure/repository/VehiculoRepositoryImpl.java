package uce.edu.ec.Infraestructure.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import uce.edu.ec.domain.model.Vehiculo;

@ApplicationScoped
public class VehiculoRepositoryImpl implements PanacheRepositoryBase<Vehiculo, Integer> {
    @Inject
    private EntityManager entityManager;
    public Vehiculo buscarVehiculoPorPLaca(String placa) {
        TypedQuery<Vehiculo> query = this.entityManager.createQuery("SELECT v FROM Vehiculo v WHERE v.placa = :placa",
                Vehiculo.class);
        query.setParameter("placa", placa);
        return query.getSingleResult();
    }

}
