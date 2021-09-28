package com.company.spring_jsp.data.entity;

//import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "user_roles")
@NamedQueries({
        @NamedQuery(name = "findAllUserRolesQuery", query = "SELECT ur FROM UserRole ur")
})
public class UserRole {

    public enum Role {
        ADMIN, USER
    }

    // Data
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    //@Column(name = "userId")
    //private Integer userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User userObject;

    @Column(name = "role", nullable = false)
    //@Enumerated(EnumType.ORDINAL)
    @Enumerated(EnumType.STRING)
    //private String role;
    private Role role;

    // Constructors
    public UserRole() {
    }

    //// Getters and Setters
    //public Integer getId() {
    //    return id;
    //}
    //
    //public void setId(Integer id) {
    //    this.id = id;
    //}
    //
    ////public Integer getUserId() {
    ////    return userId;
    ////}
    ////
    ////public void setUserId(Integer userId) {
    ////    this.userId = userId;
    ////}
    //
    //public User getUserObject() {
    //    return userObject;
    //}
    //
    //public void setUserObject(User userObject) {
    //    this.userObject = userObject;
    //}
    //
    ////public String getRole() {
    ////    return role;
    ////}
    //public Role getRole() {
    //    return role;
    //}
    //
    ////public void setRole(String role) {
    ////    this.role = role;
    ////}
    //public void setRole(Role role) {
    //    this.role = role;
    //}

    // Methods
    //@Override
    //public String toString() {
    //    return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    //}
    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                //", userObject=" + userObject +
                ", userId=" + userObject.getId() +
                ", role=" + role +
                '}';
    }

}
