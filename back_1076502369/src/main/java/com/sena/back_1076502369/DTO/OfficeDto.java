package com.sena.back_1076502369.DTO;

public class OfficeDto {
    String pais;
    Integer telefono;

    //Encapsulamiento
    //Getter
    public String getPais(){
        return pais;
    }

    public Integer getTelefono(){
        return telefono;
    }

    //Setter 
    public void setPais(String pais){
        this.pais = pais;
    }

    public void setTelefono(Integer telefono){
        this.telefono = telefono;
    }

}
