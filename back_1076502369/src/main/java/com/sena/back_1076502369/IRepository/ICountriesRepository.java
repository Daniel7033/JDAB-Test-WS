package com.sena.back_1076502369.IRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sena.back_1076502369.DTO.ICountry;
import com.sena.back_1076502369.Entity.Countries;

@Repository
public interface ICountriesRepository extends IBaseRepository<Countries, Long>{
    
    @Query(value = " SELECT \n" + //
                " c.name, \n" + //
                " count(o.id) as office, \n" + //
                " count(a.id) as airports \n" + //
                " FROM countries c \n" + //
                " INNER JOIN airports a ON a.country_id = c.id \n" + //
                " INNER JOIN office o ON o.country_id = c.id \n" + //
                " WHERE (:pais IS NULL OR c.name LIKE CONCAT('%', :pais, '%'))\n" + //
                " group by c.name; " 
    , nativeQuery = true)
    List<ICountry> findCountCountries(@Param ("pais") String pais);

}
