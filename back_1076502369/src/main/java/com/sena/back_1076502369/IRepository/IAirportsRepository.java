package com.sena.back_1076502369.IRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sena.back_1076502369.DTO.IArport;
import com.sena.back_1076502369.Entity.Airports;

@Repository
public interface IAirportsRepository extends IBaseRepository<Airports, Long>{
    @Query(value = "SELECT " +
        "a.iata_code, " +
        "a.name AS airport_name, " +
        "c.name AS country_name " +
        "FROM airports a " +
        "INNER JOIN countries c ON a.country_id = c.id " +
        "WHERE (:nombre IS NULL OR a.name LIKE CONCAT('%', :nombre, '%')) " +
        "AND (:pais IS NULL OR c.name LIKE CONCAT('%', :pais, '%'))", nativeQuery = true)
List<IArport> findNombrePaisAeropuerto(@Param("nombre") String nombre, @Param("pais") String pais);

    
}
