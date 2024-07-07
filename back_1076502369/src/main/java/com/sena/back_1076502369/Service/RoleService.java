package com.sena.back_1076502369.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.back_1076502369.DTO.IRole;
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

    @Override
    public List<IRole> findRoleCount(String title) {
        return repository.findRoleCount(title);
    }
}
