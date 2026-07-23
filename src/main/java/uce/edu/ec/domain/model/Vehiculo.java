package uce.edu.ec.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehiculo") 
public class Vehiculo {
    @Id
    @SequenceGenerator(name = "seq_vehiculo_generador", sequenceName = "seq_vehiculo", allocationSize = 1)
    @GeneratedValue(generator = "seq_vehiculo_generador", strategy = GenerationType.SEQUENCE)
    @Column(name = "vehi_id")
    private Integer id;
    @Column(name = "vehi_placa")
    private String placa;
    @Column(name = "vehi_marca")
    private String marca;
    @Column(name = "vehi_modelo")
    private String modelo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    
}
