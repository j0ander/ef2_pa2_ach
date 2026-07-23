package uce.edu.ec.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "auditando")
public class Auditando {
    @Id
    @SequenceGenerator(name = "seq_auditando_generador", sequenceName = "seq_auditando", allocationSize = 1)
    @GeneratedValue (generator = "seq_auditando_generador", strategy=GenerationType.SEQUENCE)
    @Column(name = "audi_id")
    private Integer id;
    @Column(name = "audi_placa")
    private String placa;
    @Column(name = "audi_insert")
    private Integer insert;
    @Column(name = "audi_update")
    private Integer update;
    @Column(name = "audi_delete")
    private Integer delete;
    @Column(name = "audi_select")
    private Integer select;

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

    public Integer getInsert() {
        return insert;
    }

    public void setInsert(Integer insert) {
        this.insert = insert;
    }

    public Integer getUpdate() {
        return update;
    }

    public void setUpdate(Integer update) {
        this.update = update;
    }

    public Integer getDelete() {
        return delete;
    }

    public void setDelete(Integer delete) {
        this.delete = delete;
    }

    public Integer getSelect() {
        return select;
    }

    public void setSelect(Integer select) {
        this.select = select;
    }



}
