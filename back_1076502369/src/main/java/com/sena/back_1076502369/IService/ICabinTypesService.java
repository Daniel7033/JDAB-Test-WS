package com.sena.back_1076502369.IService;

import java.util.List;

import com.sena.back_1076502369.DTO.ICabinType;
import com.sena.back_1076502369.Entity.CabinTypes;

public interface ICabinTypesService extends IBaseService<CabinTypes>{
    
    List<ICabinType> findCabinas(String nombre);

}
