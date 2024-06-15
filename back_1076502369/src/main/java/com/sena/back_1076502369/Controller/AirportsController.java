package com.sena.back_1076502369.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.back_1076502369.Entity.Airports;
import com.sena.back_1076502369.IService.IAirportsService;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/airports")
public class AirportsController extends ABaseController<Airports, IAirportsService>{
    public AirportsController(IAirportsService service){
        super(service, "Airports");
    }
}
