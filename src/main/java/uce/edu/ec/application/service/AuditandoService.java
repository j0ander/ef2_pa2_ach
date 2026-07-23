package uce.edu.ec.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.Infraestructure.repository.AuditandoRepósitoryImpl;
import uce.edu.ec.domain.model.Auditando;

@ApplicationScoped
@Transactional
public class AuditandoService {
    @Inject
    private AuditandoRepósitoryImpl impl;
    
    public void guardar(Auditando auditando) {
        impl.persist(auditando);
    }

    public Auditando buscarPorPlaca(String placa) {
        return impl.buscarPorPlaca(placa);
    }
    
    
}
