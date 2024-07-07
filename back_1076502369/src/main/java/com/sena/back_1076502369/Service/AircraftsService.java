package com.sena.back_1076502369.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.back_1076502369.DTO.IAircrafts;
import com.sena.back_1076502369.Entity.Aircrafts;
import com.sena.back_1076502369.IRepository.IAircraftsRepository;
import com.sena.back_1076502369.IRepository.IBaseRepository;
import com.sena.back_1076502369.IService.IAircraftsService;

@Service
public class AircraftsService extends ABaseService<Aircrafts> implements IAircraftsService{

    @Autowired
    private IAircraftsRepository repository;

    @Override
    protected IBaseRepository<Aircrafts, Long> getRepository(){
        return repository;
    }

    @Override
    public List<IAircrafts> sillasEjecutivas(Integer ejecutivas){
        return repository.findSillasEjecutivas(ejecutivas);
    }

}
