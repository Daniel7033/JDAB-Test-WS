package com.sena.back_1076502369.IRepository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sena.back_1076502369.Entity.Aircrafts;

@Repository
public interface IAircraftsRepository extends IBaseRepository<Aircrafts, Long>{
    
    //Consulta para buscar aviones con misma o mayor cantidad de sillas ejecutivas
    @Query(value = "SELECT " +
        " name, " +
        " total_seats, " +
        " business_sesats " +
        " FROM aircrafts " +
        " WHERE (business_steats IS NULL OR business_steats >= :ejecutivas); " 
    , nativeQuery = true)
    List<Aircrafts> findSillasEjecutivas(@Param ("ejecutivas") Integer ejecutivas);

}
