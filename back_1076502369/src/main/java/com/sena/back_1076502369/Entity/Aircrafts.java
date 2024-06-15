package com.sena.back_1076502369.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "aircrafts")
public class Aircrafts extends ABaseEntity{
    @Column(name = "name")
    private String name;

    @Column(name = "make_model")
    private String makeModel;

    @Column(name = "total_seats")
    private Integer totalSeats;

    @Column(name = "economy_seats")
    private Integer economuSeats;

    @Column(name = "business_seats")
    private Integer businessSeats;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public Integer getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
    }

    public Integer getEconomuSeats() {
        return economuSeats;
    }

    public void setEconomuSeats(Integer economuSeats) {
        this.economuSeats = economuSeats;
    }

    public Integer getBusinessSeats() {
        return businessSeats;
    }

    public void setBusinessSeats(Integer businessSeats) {
        this.businessSeats = businessSeats;
    }

}
