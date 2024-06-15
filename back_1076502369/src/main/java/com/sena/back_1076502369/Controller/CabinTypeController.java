package com.sena.back_1076502369.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.back_1076502369.Entity.CabinTypes;
import com.sena.back_1076502369.IService.ICabinTypesService;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/cabinType")
public class CabinTypeController extends ABaseController<CabinTypes, ICabinTypesService>{
    public CabinTypeController(ICabinTypesService service){
        super(service, "CabinTypes");
    }
}
