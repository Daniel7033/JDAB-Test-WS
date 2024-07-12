package com.sena.back_1076502369.DTO;

import java.time.LocalDate;

public interface ISchedules extends IGenericDto{
    Integer getDeparture();
    Integer getArrival();
    Integer getFlightNumber();
/*     Integer getTotalSillas();
    Integer getEconomicasDisponibles();
    Integer getEconomicasOcupadas();
    Integer getEjecutivasDisponibles();
    Integer getEjecutivasOcupadas();
    Integer getSillasOcupadas();
    Integer getSillasDisponibles(); */
    Double getEconomyPrice();
    String getTime();
    // String getName();
    LocalDate getDate();
}
