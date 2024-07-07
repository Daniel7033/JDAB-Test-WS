package com.sena.back_1076502369.IService;

import java.time.LocalDate;
import java.util.List;

import com.sena.back_1076502369.DTO.ISchedules;
import com.sena.back_1076502369.Entity.Schedules;

public interface ISchedulesService extends IBaseService<Schedules>{
    
    List<ISchedules> findViajes(Integer destino, Integer salida, LocalDate fechaInicio, LocalDate fechaFin);
}
