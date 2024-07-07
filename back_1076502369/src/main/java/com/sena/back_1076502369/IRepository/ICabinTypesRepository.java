package com.sena.back_1076502369.IRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sena.back_1076502369.DTO.ICabinType;
import com.sena.back_1076502369.Entity.CabinTypes;

@Repository
public interface ICabinTypesRepository extends IBaseRepository<CabinTypes, Long>{
    
    @Query(value = " SELECT " +
        " name " +
        " FROM cabin_type " +
        " WHERE (:nombre IS NULL OR name LIKE CONCAT('%', :nombre, '%')); " 
    , nativeQuery = true)
    List<ICabinType> findCabinas(@Param ("nombre") String nombre);

}
