package uce.edu.ec.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "ciudadano")
public class Ciudadano {
    @Id
    @SequenceGenerator(name = "seq_ciudadano_generador", sequenceName = "seq_ciudadano", allocationSize = 1)
    @GeneratedValue(generator = "seq_ciudadano_generador", strategy = GenerationType.SEQUENCE)
    @Column(name = "ciud_id")
    private Integer id;

    @Column(name = "ciud_cedula")
    private Integer cedula;

    @Column(name = "ciud_nombre")
    private String nombre;
    @Column(name = "ciud_apellido")
    private String apellido;
    @Column(name = "ciud_genero")
    private String genero;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Ciudadano [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido
                + ", genero=" + genero + "]";
    }

}
