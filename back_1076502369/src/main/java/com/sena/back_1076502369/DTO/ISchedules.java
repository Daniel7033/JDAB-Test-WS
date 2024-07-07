package com.sena.back_1076502369.DTO;

import java.time.LocalDate;

public interface ISchedules extends IGenericDto{
    Integer getDeparture_airport_id();
    Integer getArrival_airport_id();
    LocalDate getDate();
}
