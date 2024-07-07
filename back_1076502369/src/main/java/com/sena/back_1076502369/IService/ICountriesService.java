package com.sena.back_1076502369.IService;

import java.util.List;

import com.sena.back_1076502369.DTO.ICountry;
import com.sena.back_1076502369.Entity.Countries;

public interface ICountriesService extends IBaseService<Countries>{
    
    List<ICountry> findCountCountries(String pais);

}
