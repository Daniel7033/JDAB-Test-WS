package com.sena.back_1076502369.IRepository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sena.back_1076502369.DTO.IAircrafts;
import com.sena.back_1076502369.Entity.Aircrafts;

@Repository
public interface IAircraftsRepository extends IBaseRepository<Aircrafts, Long>{
    
    //Consulta para buscar aviones con misma o mayor cantidad de sillas ejecutivas
    @Query(value = "SELECT " +
        " name, " +
        " total_seats, " +
        " business_seats " +
        " FROM aircrafts " +
        " WHERE (:ejecutivas IS NULL OR business_seats >= :ejecutivas); " 
    , nativeQuery = true)
    List<IAircrafts> findSillasEjecutivas(@Param ("ejecutivas") Integer ejecutivas);

}
