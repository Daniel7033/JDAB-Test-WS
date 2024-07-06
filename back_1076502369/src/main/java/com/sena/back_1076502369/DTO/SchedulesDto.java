package com.sena.back_1076502369.DTO;

import java.time.LocalDate;

public class SchedulesDto {
    Integer destino;
    Integer salida;
    LocalDate fechaInicio;
    LocalDate fechaFin;
    
    //Encapsulamiento...
    //Getter
    public Integer getDestino(){
        return destino;
    }    

    public Integer getSalida(){
        return salida;
    }

    public LocalDate getFechaInicio(){
        return fechaInicio;
    }

    public LocalDate getFechaFin(){
        return fechaFin;
    }

    //Setter
    public void setDestino(Integer destino){
        this.destino = destino;
    }

    public void setSalida(Integer salida){
        this.salida = salida;
    }

    public void setFechaInicio(LocalDate fechaInicio){
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(LocalDate fechaFin){
        this.fechaFin = fechaFin;
    }
}

    
