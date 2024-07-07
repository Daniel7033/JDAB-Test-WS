package com.sena.back_1076502369.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.back_1076502369.Entity.Aircrafts;
import com.sena.back_1076502369.DTO.AircraftsDto;
import com.sena.back_1076502369.DTO.IAircrafts;
import com.sena.back_1076502369.IService.IAircraftsService;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/aircrafts")
public class AircraftsController extends ABaseController<Aircrafts, IAircraftsService>{
    public AircraftsController(IAircraftsService service){
        super(service, "Aircrafts");
    }

    @PostMapping("/sillasEjecutivas")
        public ResponseEntity<List<IAircrafts>> sillasEjecutivas(@RequestBody AircraftsDto aircrafts){
            try{
                return ResponseEntity.ok(service.sillasEjecutivas(aircrafts.getEjecutivas()));
            } catch (Exception e) {
                return ResponseEntity.internalServerError().body(null);
            }
        }

}
