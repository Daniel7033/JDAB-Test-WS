package com.sena.back_1076502369.DTO;

import java.util.Date;

public interface IVuelosDto extends IGenericDto {
    String getDeparture();
    String getArrival();
    Integer getFlightNumber();
    Double getEconomyPrice();
    Date getSalida();
    Date getRetorno();
    
}
    
