package com.sena.back_1076502369.DTO;

import java.time.LocalDate;

public class SchedulesDto {
    Integer destino;
    Integer salida;
    LocalDate fechaOrigen;
    LocalDate fechaLlegada;
    
    //Encapsulamiento...
    //Getter
    public Integer getDestino(){
        return destino;
    }    

    public Integer getSalida(){
        return salida;
    }

    public LocalDate getFechaOrigen(){
        return fechaOrigen;
    }

    public LocalDate getFechaLlegada(){
        return fechaLlegada;
    }

    //Setter
    public void setDestino(Integer destino){
        this.destino = destino;
    }

    public void setSalida(Integer salida){
        this.salida = salida;
    }

    public void setFechaOrigen(LocalDate fechaOrigen){
        this.fechaOrigen = fechaOrigen;
    }

    public void setFechaLlegada(LocalDate fechaLlegada){
        this.fechaLlegada = fechaLlegada;
    }
}

    
