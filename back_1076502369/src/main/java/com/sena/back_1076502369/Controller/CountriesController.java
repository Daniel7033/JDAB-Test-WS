package com.sena.back_1076502369.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.back_1076502369.Entity.Countries;
import com.sena.back_1076502369.IService.ICountriesService;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/countries")
public class CountriesController extends ABaseController<Countries, ICountriesService>{
    public CountriesController(ICountriesService service){
        super(service, "ountries");
    }
}
