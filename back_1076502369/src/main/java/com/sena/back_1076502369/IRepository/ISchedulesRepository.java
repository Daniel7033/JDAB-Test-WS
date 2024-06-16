package com.sena.back_1076502369.IRepository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sena.back_1076502369.Entity.Schedules;
import com.sena.back_1076502369.DTO.IVuelosDto;

@Repository
public interface ISchedulesRepository extends IBaseRepository<Schedules, Long> {

        @Query(value = "SELECT " +
                        "dep.iata_code as departure, " +
                        "arr.iata_code as arrival, " +
                        "sc.date as salida," +
                        "sc.time," +
                        "sc.flight_number 'flightNumber', " +
                        "sc.economy_price as 'economyPrice' " +
                        "FROM schedules sc " +
                        "INNER JOIN routes r ON sc.route_id = r.id " +
                        "INNER JOIN airports dep ON r.departure_airport_id = dep.id " +
                        "INNER JOIN airports arr ON r.arrival_airport_id = arr.id " +
                        "WHERE (dep.iata_code IS NULL OR dep.iata_code LIKE CONCAT('%', :departure, '%')) " +
                        "AND (arr.iata_code IS NULL OR arr.iata_code LIKE CONCAT('%', :arrival, '%')) " +
                        "AND (sc.date IS NULL OR sc.date LIKE CONCAT('%', :salida, '%'))", nativeQuery = true)
        List<IVuelosDto> getReserva(@Param("departure") String departure, @Param("arrival") String arrival,
                        @Param("salida") Date salida);
}
