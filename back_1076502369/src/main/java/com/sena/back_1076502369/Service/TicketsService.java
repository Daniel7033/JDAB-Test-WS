package com.sena.back_1076502369.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.sena.back_1076502369.Entity.Tickets;
import com.sena.back_1076502369.Entity.Users;
import com.sena.back_1076502369.IRepository.ITicketsRepository;
import com.sena.back_1076502369.IRepository.IBaseRepository;
import com.sena.back_1076502369.IService.ITicketsService;
import com.sena.back_1076502369.IService.IUsersService;

@Service
public class TicketsService  extends ABaseService<Tickets> implements ITicketsService{

    @Autowired
    private ITicketsRepository repository;

    @Override
    protected IBaseRepository<Tickets, Long> getRepository(){
        return repository;
    }

    @Lazy
    private final IUsersService usersService;
    
    public TicketsService(@Lazy IUsersService usersService, ITicketsRepository repository){
        this.repository = repository;
        this.usersService = usersService;
    }

    @Override
    public Tickets saveUser(Users entity) throws Exception{
        Users users = usersService.save(entity);
        Tickets tickets = new Tickets();
        tickets.setUserId(users);
        users.setActive(true);
        tickets.setConfirmed(true);
        Tickets entityTickets = repository.save(tickets);
        return entityTickets;
    }
}
