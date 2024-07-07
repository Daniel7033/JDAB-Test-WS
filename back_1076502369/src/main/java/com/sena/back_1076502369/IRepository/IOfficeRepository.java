package com.sena.back_1076502369.IRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sena.back_1076502369.DTO.IOffice;
import com.sena.back_1076502369.Entity.Office;

@Repository
public interface IOfficeRepository extends IBaseRepository<Office, Long>{
    
    @Query(value = "SELECT " +
        " o.title, " +
        " o.phone, " +
        " o.contact, " +
        " c.name " +
        " FROM office o " +
        " INNER JOIN countries c ON o.country_id = c.id " +
        " WHERE (:pais IS NULL OR c.name LIKE CONCAT('%', :pais, '%')) " +
        " AND (:telefono IS NULL OR o.phone = :telefono OR :telefono = 0);" 
    , nativeQuery = true)
    List<IOffice> findOfficeByCountry(@Param ("pais") String pais, 
                                    @Param ("telefono") Integer telefono);

}
