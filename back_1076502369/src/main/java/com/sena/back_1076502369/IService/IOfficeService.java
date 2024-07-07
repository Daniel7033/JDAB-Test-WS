package com.sena.back_1076502369.IService;

import java.util.List;

import com.sena.back_1076502369.DTO.IOffice;
import com.sena.back_1076502369.Entity.Office;

public interface IOfficeService extends IBaseService<Office>{
    
    List<IOffice> findOfficeByCountry(String pais, Integer telefono);

}
