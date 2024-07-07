package com.sena.back_1076502369.IService;

import java.util.List;

import com.sena.back_1076502369.DTO.IAircrafts;
import com.sena.back_1076502369.Entity.Aircrafts;

public interface IAircraftsService extends IBaseService<Aircrafts>{

    List<IAircrafts> sillasEjecutivas(Integer ejecutivas);

}