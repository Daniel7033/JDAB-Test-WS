package com.sena.back_1076502369.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.back_1076502369.Entity.Schedules;
import com.sena.back_1076502369.DTO.ISchedules;
import com.sena.back_1076502369.DTO.SchedulesDto;
import com.sena.back_1076502369.IService.ISchedulesService;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/schedules")
public class SchedulesController extends ABaseController<Schedules, ISchedulesService> {
    public SchedulesController(ISchedulesService service) {
        super(service, "Schedules");
    }

    @PostMapping("/findViajes")
    public ResponseEntity<List<ISchedules>> findViajes(@RequestBody SchedulesDto schedules){
        try{
            return ResponseEntity.ok(service.findViajes(schedules.getDestino(), schedules.getSalida(), schedules.getFechaOrigen(), schedules.getFechaLlegada()));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    } 
    
    @PostMapping("/findViajesRetorno")
    public ResponseEntity<List<ISchedules>> findViajesRetorno(@RequestBody SchedulesDto schedules){
        try{
            return ResponseEntity.ok(service.findViajesRetorno(schedules.getSalida(), schedules.getFechaOrigen(), schedules.getFechaLlegada()));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }
}
