package com.sena.back_1076502369.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.back_1076502369.Entity.Office;
import com.sena.back_1076502369.IRepository.IOfficeRepository;
import com.sena.back_1076502369.IRepository.IBaseRepository;
import com.sena.back_1076502369.IService.IOfficeService;

@Service
public class OfficeService extends ABaseService<Office> implements IOfficeService{

    @Autowired
    private IOfficeRepository repository;

    @Override
    protected IBaseRepository<Office, Long> getRepository(){
        return repository;
    }
}
