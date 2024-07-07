package com.sena.back_1076502369.IService;

import java.util.List;

import com.sena.back_1076502369.DTO.IArport;
import com.sena.back_1076502369.Entity.Airports;

public interface IAirportsService extends IBaseService<Airports>{

    List<IArport> findNombrePaisAeropuerto(String nombre, String pais);
    
}
