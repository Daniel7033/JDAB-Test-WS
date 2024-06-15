package com.sena.back_1076502369.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.back_1076502369.Entity.Tickets;
import com.sena.back_1076502369.IService.ITicketsService;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/tickets")
public class TicketsController extends ABaseController<Tickets, ITicketsService>{
    public TicketsController(ITicketsService service){
        super(service, "Tickets");
    }
}
