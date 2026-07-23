package uce.edu.ec.Infraestructure.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Ciudadano;

@ApplicationScoped
@Transactional
public class CiudadanoRepositoryImpl implements PanacheRepositoryBase<Ciudadano, Integer> {

}
