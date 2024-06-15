package com.sena.back_1076502369.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.back_1076502369.Entity.CabinTypes;
import com.sena.back_1076502369.IRepository.ICabinTypesRepository;
import com.sena.back_1076502369.IRepository.IBaseRepository;
import com.sena.back_1076502369.IService.ICabinTypesService;

@Service
public class CabinTypeService  extends ABaseService<CabinTypes> implements ICabinTypesService{

    @Autowired
    private ICabinTypesRepository repository;

    @Override
    protected IBaseRepository<CabinTypes, Long> getRepository(){
        return repository;
    }
}
