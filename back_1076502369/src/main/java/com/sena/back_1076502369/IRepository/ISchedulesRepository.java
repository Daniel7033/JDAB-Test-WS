package com.sena.back_1076502369.IRepository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sena.back_1076502369.DTO.ISchedules;
import com.sena.back_1076502369.Entity.Schedules;

@Repository
public interface ISchedulesRepository extends IBaseRepository<Schedules, Long> {

        
        @Query(value = "SELECT " +
        "r.departure_airport_id AS departure, " +
        "r.arrival_airport_id AS arrivall, " +
        " sc.date, " +
        " sc.time, " +
        " sc.flight_number, " +
        " sc.economy_price " +
        "FROM schedules sc " +
        "INNER JOIN routes r ON sc.route_id = r.id " +
        "INNER JOIN airports dep ON r.departure_airport_id = dep.id " +
        "INNER JOIN airports arr ON r.arrival_airport_id = arr.id " +
        "WHERE (:destino IS NULL OR r.departure_airport_id = :destino OR :destino = 0) " +
        "AND (:salida IS NULL OR r.arrival_airport_id = :salida OR :salida = 0) " +
        "AND (:fechaInicio IS NULL OR sc.date >= :fechaInicio) " +
        " AND (:fechaFin IS NULL OR sc.date <= :fechaFin); ",
        nativeQuery = true)
        List<ISchedules> findViajes(@Param("destino") Integer
        destino, @Param("salida") Integer salida, @Param("fechaInicio") LocalDate
        fechaInicio, @Param("fechaFin") LocalDate fechaFin);
        

        
}
