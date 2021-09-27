package com.company.spring_jsp.data.dao;

import com.company.spring_jsp.data.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRoleDao extends JpaRepository<UserRole, Long> {

    UserRole findUserRoleById(@Param("id") Integer id);



}
