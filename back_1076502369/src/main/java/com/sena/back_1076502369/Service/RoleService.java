package com.sena.back_1076502369.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.back_1076502369.Entity.Role;
import com.sena.back_1076502369.IRepository.IRoleRepository;
import com.sena.back_1076502369.IRepository.IBaseRepository;
import com.sena.back_1076502369.IService.IRoleService;

@Service
public class RoleService extends ABaseService<Role> implements IRoleService{

    @Autowired
    private IRoleRepository repository;

    @Override
    protected IBaseRepository<Role, Long> getRepository(){
        return repository;
    }
}
