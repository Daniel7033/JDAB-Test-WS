package com.sena.back_1076502369.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.back_1076502369.Entity.Airports;
import com.sena.back_1076502369.IRepository.IAirportsRepository;
import com.sena.back_1076502369.IRepository.IBaseRepository;
import com.sena.back_1076502369.IService.IAirportsService;

@Service
public class AirportsService extends ABaseService<Airports> implements IAirportsService{

    @Autowired
    private IAirportsRepository repository;

    @Override
    protected IBaseRepository<Airports, Long> getRepository(){
        return repository;
    }
}
