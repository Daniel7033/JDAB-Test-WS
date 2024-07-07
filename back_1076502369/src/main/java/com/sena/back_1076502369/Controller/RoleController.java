package com.sena.back_1076502369.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.back_1076502369.DTO.IRole;
import com.sena.back_1076502369.DTO.RoleDto;
import com.sena.back_1076502369.Entity.Role;
import com.sena.back_1076502369.IService.IRoleService;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/role")
public class RoleController extends ABaseController<Role, IRoleService>{
    protected RoleController(IRoleService service){
        super(service, "Role");
    }

    @PostMapping("/Roles")
    public ResponseEntity<List<IRole>> findRoleCount(@RequestBody RoleDto role){
        try {
            return ResponseEntity.ok(service.findRoleCount(role.getTitle()));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

}
