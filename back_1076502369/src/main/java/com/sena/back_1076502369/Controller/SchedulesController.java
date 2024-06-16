package com.sena.back_1076502369.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sena.back_1076502369.DTO.ApiResponseDto;
import com.sena.back_1076502369.DTO.IVuelosDto;
import com.sena.back_1076502369.Entity.Schedules;
import com.sena.back_1076502369.IService.ISchedulesService;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/schedules")
public class SchedulesController extends ABaseController<Schedules, ISchedulesService> {
    public SchedulesController(ISchedulesService service) {
        super(service, "Schedules");
    }

    @GetMapping("/salidas/")
    public ResponseEntity<ApiResponseDto<List<IVuelosDto>>> show(@RequestParam(required = false) String departure,
            @RequestParam(required = false) String arrival, @RequestParam(required = false) Date salida) {
        try {
            if (departure == null || arrival == null || salida == null) {
                return ResponseEntity.badRequest().body(
                        new ApiResponseDto<>("Los valores de: departure, arrival, salida. Son nulos", null, false));
            } else {
                List<IVuelosDto> entity = service.getReserva(departure, arrival, salida);
                return ResponseEntity.ok(new ApiResponseDto<>("Registro encontrado", entity, true));
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(new ApiResponseDto<List<IVuelosDto>>(e.getMessage(), null, false));
        }
    }
}
