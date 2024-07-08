package com.sena.back_1076502369.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.back_1076502369.DTO.ApiResponseDto;
import com.sena.back_1076502369.Entity.Tickets;
import com.sena.back_1076502369.Entity.Users;
import com.sena.back_1076502369.IService.ITicketsService;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/tickets")
public class TicketsController extends ABaseController<Tickets, ITicketsService>{
    public TicketsController(ITicketsService service){
        super(service, "Tickets");
    }

    @PostMapping("/saveUsers")
    public ResponseEntity<ApiResponseDto<Tickets>> save(@RequestBody Users entity){
        try {
            return ResponseEntity.ok(new ApiResponseDto<Tickets>("Usuario registrado", service.saveUser(entity), true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<Tickets>(e.getMessage(), null, false));
        }
    }
}
