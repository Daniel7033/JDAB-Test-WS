package com.sena.back_1076502369.IService;

import com.sena.back_1076502369.Entity.Tickets;
import com.sena.back_1076502369.Entity.Users;

public interface ITicketsService extends IBaseService<Tickets>{
    Tickets saveUser(Users entity) throws Exception;
}
