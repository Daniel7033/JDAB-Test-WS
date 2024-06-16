package com.sena.back_1076502369.IService;

import java.util.Date;
import java.util.List;

import com.sena.back_1076502369.DTO.IVuelosDto;
import com.sena.back_1076502369.Entity.Schedules;

public interface ISchedulesService extends IBaseService<Schedules>{
    
    List<IVuelosDto> getReserva(String departure, String arrival, Date salida);
}
