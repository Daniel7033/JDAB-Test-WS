package com.sena.back_1076502369.IService;

import java.util.List;

import com.sena.back_1076502369.DTO.IRole;
import com.sena.back_1076502369.Entity.Role;

public interface IRoleService extends IBaseService<Role>{

    List<IRole> findRoleCount(String title);
    
}
