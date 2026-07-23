package uce.edu.ec.Infraestructure.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Auditando;

@ApplicationScoped
@Transactional
public class AuditandoRepósitoryImpl implements PanacheRepositoryBase<Auditando,Integer> {
    @Inject
    private EntityManager entityManager;
   
    public Auditando buscarPorPlaca(String placa) {
        TypedQuery<Auditando> query = entityManager.createQuery("SELECT a FROM Auditando a WHERE a.placa = :placa", Auditando.class);
        query.setParameter("placa", placa);
        return query.getSingleResult();
    }
}
