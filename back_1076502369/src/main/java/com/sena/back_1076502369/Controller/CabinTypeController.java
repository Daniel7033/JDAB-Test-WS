package com.sena.back_1076502369.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.back_1076502369.DTO.CabinTypesDto;
import com.sena.back_1076502369.DTO.ICabinType;
import com.sena.back_1076502369.Entity.CabinTypes;
import com.sena.back_1076502369.IService.ICabinTypesService;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/cabinType")
public class CabinTypeController extends ABaseController<CabinTypes, ICabinTypesService>{
    protected CabinTypeController(ICabinTypesService service){
        super(service, "CabinTypes");
    }

    @PostMapping("/cabinasFiltro")
    public ResponseEntity<List<ICabinType>> cabinaFiltro(@RequestBody CabinTypesDto cabin){
        try {
            return ResponseEntity.ok(service.findCabinas(cabin.getNombre()));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }
}
