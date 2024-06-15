package com.sena.back_1076502369.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.back_1076502369.Entity.Routes;
import com.sena.back_1076502369.IService.IRoutesService;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/routes")
public class RoutesController extends ABaseController<Routes, IRoutesService>{
    public RoutesController(IRoutesService service){
        super(service, "Routes");
    }
}
