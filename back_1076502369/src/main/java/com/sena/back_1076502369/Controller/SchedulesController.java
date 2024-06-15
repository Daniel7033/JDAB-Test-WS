package com.sena.back_1076502369.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.back_1076502369.Entity.Schedules;
import com.sena.back_1076502369.IService.ISchedulesService;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/schedules")
public class SchedulesController extends ABaseController<Schedules, ISchedulesService>{
    public SchedulesController(ISchedulesService service){
        super(service, "Schedules");
    }
}
