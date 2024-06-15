package com.sena.back_1076502369.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.back_1076502369.Entity.Tickets;
import com.sena.back_1076502369.IRepository.ITicketsRepository;
import com.sena.back_1076502369.IRepository.IBaseRepository;
import com.sena.back_1076502369.IService.ITicketsService;

@Service
public class TicketsService  extends ABaseService<Tickets> implements ITicketsService{

    @Autowired
    private ITicketsRepository repository;

    @Override
    protected IBaseRepository<Tickets, Long> getRepository(){
        return repository;
    }
}
