package com.sena.back_1076502369.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.back_1076502369.DTO.AirportsDto;
import com.sena.back_1076502369.DTO.IArport;
import com.sena.back_1076502369.Entity.Airports;
import com.sena.back_1076502369.IService.IAirportsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/airports")
public class AirportsController extends ABaseController<Airports, IAirportsService>{
    protected AirportsController(IAirportsService service){
        super(service, "Airports");
    }

    @PostMapping("/nombrePais")
    public ResponseEntity<List<IArport>> findNombrePaisAeropuerto(@RequestBody AirportsDto airports) {
        try {
            System.out.println("El controlador: "+ airports.getNombre() + airports.getPais());
            return ResponseEntity.ok(service.findNombrePaisAeropuerto(airports.getNombre(), airports.getPais()));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }
    
}
