package com.company.spring_jsp.data.dao;

import com.company.spring_jsp.data.entity.User;
import com.company.spring_jsp.data.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.lang.annotation.Native;
import java.util.List;
import java.util.Map;

public interface UserDao extends JpaRepository<User, Long> {

    User findById(@Param("id") Integer id);

    User findByEmail(@Param("email") String email);

    //User findByConfirmEmailToken(@Param("confirmEmailToken") String confirmEmailToken);

    @Query(value = "SELECT u FROM User u WHERE u.firstName = :firstNameIn AND u.lastName = :lastNameIn")
    List<User> findByFullName(@Param("firstName") String firstNameIn, @Param("lastName") String lastNameIn);

    //@Query(value="SELECT u.* FROM User u WHERE u.reset_token = :token and u.reset_date > date_sub(now(), interval :hours hour)", nativeQuery = true)
    //public User findByResetToken(@Param("token") String resetToken, @Param("hours") int hours);

    //@Query("SELECT ur FROM UserRole ur WHERE ur.userObject.id = :userId")
    //List<UserRole> getUserRolesById(Integer userId);
    @Query("SELECT u.userRoles FROM User u WHERE u.id = :idIn")
    List<UserRole> getUserRolesById(Integer idIn);

    //@Query(value="SELECT @@global.time_zone as globaltz, @@session.time_zone as sessiontz, now() as now", nativeQuery = true);
    //Map<String, Object> queryTimezone();

}
