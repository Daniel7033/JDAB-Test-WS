package com.sena.back_1076502369.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.back_1076502369.Entity.Users;
import com.sena.back_1076502369.IService.IUsersService;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/users")
public class UsersController extends ABaseController<Users, IUsersService>{
    public UsersController(IUsersService service){
        super(service, "Users");
    }
}
