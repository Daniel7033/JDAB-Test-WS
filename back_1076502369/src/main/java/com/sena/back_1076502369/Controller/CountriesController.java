package com.sena.back_1076502369.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.back_1076502369.DTO.CountryDto;
import com.sena.back_1076502369.DTO.ICountry;
import com.sena.back_1076502369.Entity.Countries;
import com.sena.back_1076502369.IService.ICountriesService;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/countries")
public class CountriesController extends ABaseController<Countries, ICountriesService>{
    protected CountriesController(ICountriesService service){
        super(service, "ountries");
    }

    @PostMapping("/cantidad")
    public ResponseEntity<List<ICountry>> findCountCountries(@RequestBody CountryDto country){
        try {
            return ResponseEntity.ok(service.findCountCountries(country.getPais()));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }
}
