package com.company.spring_jsp.data.dao;

import com.company.spring_jsp.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface UserDao extends JpaRepository<User, Long> {

    User findById(@Param("id") Integer id);

    User findByEmail(@Param("email") String email);

    @Query(value = "SELECT u FROM User u WHERE u.firstName = :firstNameIn AND u.lastName = :lastNameIn")
    List<User> findByFullName(@Param("firstName") String firstNameIn, @Param("lastName") String lastNameIn);

    //@Query(value="SELECT @@global.time_zone as globaltz, @@session.time_zone as sessiontz, now() as now", nativeQuery);
    //Map<String, Object> queryTimezone();

}
