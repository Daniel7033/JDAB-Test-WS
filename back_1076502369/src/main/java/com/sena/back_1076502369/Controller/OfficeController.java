package com.sena.back_1076502369.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.back_1076502369.Entity.Office;
import com.sena.back_1076502369.IService.IOfficeService;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/office")
public class OfficeController extends ABaseController<Office, IOfficeService>{
    public OfficeController(IOfficeService service){
        super(service, "Office");
    }
}
