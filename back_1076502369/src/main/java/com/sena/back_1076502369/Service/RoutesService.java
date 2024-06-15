package com.sena.back_1076502369.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.back_1076502369.Entity.Routes;
import com.sena.back_1076502369.IRepository.IRoutesRepository;
import com.sena.back_1076502369.IRepository.IBaseRepository;
import com.sena.back_1076502369.IService.IRoutesService;

@Service
public class RoutesService extends ABaseService<Routes> implements IRoutesService{

    @Autowired
    private IRoutesRepository repository;

    @Override
    protected IBaseRepository<Routes, Long> getRepository(){
        return repository;
    }
}
