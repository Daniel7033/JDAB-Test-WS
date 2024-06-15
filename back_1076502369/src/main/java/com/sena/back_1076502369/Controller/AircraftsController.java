package com.sena.back_1076502369.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.back_1076502369.Entity.Aircrafts;
import com.sena.back_1076502369.IService.IAircraftsService;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/aircrafts")
public class AircraftsController extends ABaseController<Aircrafts, IAircraftsService>{
    public AircraftsController(IAircraftsService service){
        super(service, "Aircrafts");
    }
}
