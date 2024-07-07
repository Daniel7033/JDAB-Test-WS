package com.sena.back_1076502369.DTO;

public class AirportsDto{
    String nombre;
    String pais;

    //Encapsulamiento
    //Getter
    public String getNombre(){
        return nombre;
    }

    public String getPais(){
        return pais;
    }

    //Setter
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setPais(String pais){
        this.pais = pais;
    }

}
