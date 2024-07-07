package com.sena.back_1076502369.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.back_1076502369.DTO.IOffice;
import com.sena.back_1076502369.DTO.OfficeDto;
import com.sena.back_1076502369.Entity.Office;
import com.sena.back_1076502369.IService.IOfficeService;


@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/office")
public class OfficeController extends ABaseController<Office, IOfficeService>{
    protected OfficeController(IOfficeService service){
        super(service, "Office");
    }

    @PostMapping("/officeByCountry")
    public ResponseEntity<List<IOffice>> findOfficeByCountry(@RequestBody OfficeDto office){
        try {
            return ResponseEntity.ok(service.findOfficeByCountry(office.getPais(), office.getTelefono()));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }
}
