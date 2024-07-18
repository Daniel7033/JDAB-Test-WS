package com.sena.back_1076502369.DTO;

import java.time.LocalDate;

public interface ISchedules extends IGenericDto{
    String getDestino();
    String getSalida();
    Integer getFlightNumber();
    Integer getSillasOcupadas();
    Integer getSillasDisponibles();
    Double getEconomyPrice();
    String getTime();
    LocalDate getDate();
/*  Integer getTotalSillas();
    Integer getEconomicasDisponibles();
    Integer getEconomicasOcupadas();
    Integer getEjecutivasDisponibles();
    String getName();
    Integer getEjecutivasOcupadas();*/
}
