package com.sena.back_1076502369.IRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sena.back_1076502369.DTO.IRole;
import com.sena.back_1076502369.Entity.Role;

@Repository
public interface IRoleRepository extends IBaseRepository<Role, Long>{
    
    @Query(value = " SELECT " +
        " r.title, " + 
        " count(u.id) as cantidad " +
        " FROM users u " +
        " INNER JOIN role r ON u.role_id = r.id " +
        " WHERE (:title IS NULL OR r.title LIKE CONCAT('%', :title, '%')) " +
        " GROUP BY r.title; "
    , nativeQuery = true)
    List<IRole> findRoleCount(@Param ("title") String title);

}
