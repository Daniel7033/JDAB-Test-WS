package com.sena.back_1076502369.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.back_1076502369.DTO.ICountry;
import com.sena.back_1076502369.Entity.Countries;
import com.sena.back_1076502369.IRepository.ICountriesRepository;
import com.sena.back_1076502369.IRepository.IBaseRepository;
import com.sena.back_1076502369.IService.ICountriesService;

@Service
public class CountriesService extends ABaseService<Countries> implements ICountriesService{

    @Autowired
    private ICountriesRepository repository;

    @Override
    protected IBaseRepository<Countries, Long> getRepository(){
        return repository;
    }

    @Override
    public List<ICountry> findCountCountries(String pais) {
        return repository.findCountCountries(pais);
    }
}
