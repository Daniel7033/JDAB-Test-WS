package com.sena.back_1076502369.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.back_1076502369.Entity.Role;
import com.sena.back_1076502369.IService.IRoleService;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/role")
public class RoleController extends ABaseController<Role, IRoleService>{
    public RoleController(IRoleService service){
        super(service, "Role");
    }
}
