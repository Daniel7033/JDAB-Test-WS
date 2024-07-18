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

        /*
         * @Query(value = "SELECT " +
         * "r.departure_airport_id AS departure, " +
         * "r.arrival_airport_id AS arrivall, " +
         * " sc.date, " +
         * " sc.time, " +
         * " sc.flight_number, " +
         * " sc.economy_price " +
         * "FROM schedules sc " +
         * "INNER JOIN routes r ON sc.route_id = r.id " +
         * "INNER JOIN airports dep ON r.departure_airport_id = dep.id " +
         * "INNER JOIN airports arr ON r.arrival_airport_id = arr.id " +
         * "WHERE (:destino IS NULL OR r.departure_airport_id = :destino OR :destino = 0) "
         * +
         * "AND (:salida IS NULL OR r.arrival_airport_id = :salida OR :salida = 0) " +
         * "AND (:fechaInicio IS NULL OR sc.date >= :fechaInicio) " +
         * " AND (:fechaFin IS NULL OR sc.date <= :fechaFin); ",
         * nativeQuery = true)
         * List<ISchedules> findViajes(@Param("destino") Integer
         * destino, @Param("salida") Integer salida, @Param("fechaInicio") LocalDate
         * fechaInicio, @Param("fechaFin") LocalDate fechaFin);
         */

        @Query(value = "SELECT " +
                        "a1.iata_code AS salida, a2.iata_code AS destino, sc.date, sc.time, sc.flight_number, sc.economy_price, COUNT(tk.cabintype_id) AS sillasOcupadas, ((ac.economy_seats + ac.business_seats) - COUNT(tk.cabintype_id)) AS sillasDisponibles " +
                        "FROM schedules AS sc " +
                        "INNER JOIN routes AS r ON sc.route_id = r.id " +
                        "INNER JOIN airports AS a1 ON r.departure_airport_id = a1.id " +
                        "INNER JOIN airports AS a2 ON r.arrival_airport_id = a2.id " +
                        "INNER JOIN aircrafts AS ac ON sc.aircraft_id = ac.id " +
                        "INNER JOIN tickets AS tk ON tk.schedule_id = sc.id " +
                        "INNER JOIN cabin_type AS ct ON tk.cabintype_id = ct.id " +
                        "WHERE (:salida IS NULL OR r.departure_airport_id = :salida OR :salida = 0) " +
                        "AND (:destino IS NULL OR r.arrival_airport_id = :destino OR :destino = 0) " +
                        "AND (:fechaOrigen IS NULL OR sc.date >= :fechaOrigen) " +
                        "AND (:fechaLlegada IS NULL OR sc.date <= :fechaLlegada) " +
                        "GROUP BY sc.id " +
                        "ORDER BY tk.id ASC;", nativeQuery = true)
        List<ISchedules> findViajes(@Param("destino") Integer destino,
                                @Param("salida") Integer salida,
                                @Param("fechaOrigen") LocalDate fechaOrigen,
                                @Param("fechaLlegada") LocalDate fechaLlegada);

        @Query(value = "SELECT " + 
                        "a2.iata_code AS salida, a1.iata_code AS destino, sc.date, sc.time, sc.flight_number, sc.economy_price, COUNT(tk.cabintype_id) AS sillasOcupadas, ((ac.economy_seats + ac.business_seats) - COUNT(tk.cabintype_id)) AS sillasDisponibles " + 
                        "FROM schedules AS sc " + 
                        "INNER JOIN routes AS r ON sc.route_id = r.id " + 
                        "INNER JOIN airports AS a1 ON r.departure_airport_id = a1.id " + 
                        "INNER JOIN airports AS a2 ON r.arrival_airport_id = a2.id " + 
                        "INNER JOIN aircrafts AS ac ON sc.aircraft_id = ac.id " + 
                        "INNER JOIN tickets AS tk ON tk.schedule_id = sc.id " + 
                        "INNER JOIN cabin_type AS ct ON tk.cabintype_id = ct.id " + 
                        "WHERE (:salida IS NULL OR r.arrival_airport_id = :salida OR :salida = 0) " + 
                        "AND (:fechaOrigen IS NULL OR sc.date >= :fechaOrigen) " + 
                        "AND (:fechaLlegada IS NULL OR sc.date <= :fechaLlegada) " + 
                        "GROUP BY sc.id " + 
                        "ORDER BY tk.id ASC;", nativeQuery = true)
        List<ISchedules> findViajesRetorno(@Param("salida") Integer salida,
                                        @Param("fechaOrigen") LocalDate fechaOrigen,
                                        @Param("fechaLlegada") LocalDate fechaLlegada);
}
