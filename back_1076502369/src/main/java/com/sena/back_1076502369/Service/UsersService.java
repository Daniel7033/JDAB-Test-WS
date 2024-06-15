package com.sena.back_1076502369.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.back_1076502369.Entity.Users;
import com.sena.back_1076502369.IRepository.IUsersRepository;
import com.sena.back_1076502369.IRepository.IBaseRepository;
import com.sena.back_1076502369.IService.IUsersService;

@Service
public class UsersService extends ABaseService<Users> implements IUsersService{

    @Autowired
    private IUsersRepository repository;

    @Override
    protected IBaseRepository<Users, Long> getRepository(){
        return repository;
    }
}
