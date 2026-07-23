package uce.edu.ec.application.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.Infraestructure.repository.CiudadanoRepositoryImpl;
import uce.edu.ec.domain.model.Ciudadano;

@ApplicationScoped
@Transactional
public class CiudadanoService {
    @Inject
    private CiudadanoRepositoryImpl impl;

    
      public void leerRutaDeArchivo(String ruta) throws IOException {
      Path path = Paths.get(ruta);
      List<String> lineas = Files.readAllLines(path);
        for (String linea : lineas) {
            String[] datos = linea.split(",");
            if (datos.length == 4) {
                String cedula = datos[0].trim();
                String nombre = datos[1].trim();
                String apellido = datos[2].trim();
                String genero = datos[3].trim();
                Ciudadano ciudadano = new Ciudadano();
                ciudadano.setCedula(Integer.parseInt(cedula));
                ciudadano.setNombre(nombre);
                ciudadano.setApellido(apellido);
                ciudadano.setGenero(genero);
                impl.persist(ciudadano);
            }
        }
     }
    

}
