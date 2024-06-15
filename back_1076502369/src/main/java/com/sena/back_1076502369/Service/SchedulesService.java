package com.sena.back_1076502369.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.back_1076502369.Entity.Schedules;
import com.sena.back_1076502369.IRepository.ISchedulesRepository;
import com.sena.back_1076502369.IRepository.IBaseRepository;
import com.sena.back_1076502369.IService.ISchedulesService;

@Service
public class SchedulesService  extends ABaseService<Schedules> implements ISchedulesService{

    @Autowired
    private ISchedulesRepository repository;

    @Override
    protected IBaseRepository<Schedules, Long> getRepository(){
        return repository;
    }
}
