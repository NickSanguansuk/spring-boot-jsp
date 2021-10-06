package com.company.spring_jsp.web.form;

import com.company.spring_jsp.web.validation.EmailUnique;
import com.company.spring_jsp.web.validation.TwoFieldsAreEqual;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@TwoFieldsAreEqual(fieldOneName = "confirmPassword", fieldTwoName = "password", message = "Password and Confirm Password must be the same.")
public class CreateUser2Form {
    // Data
    private Integer id;

    @NotEmpty(message = "First Name cannot be empty.")
    private String firstName;

    @NotEmpty(message = "Last Name cannot be empty.")
    private String lastName;

    //@NotNull
    @NotEmpty(message = "Email cannot be empty.")
    //@Email(message = "@Email is invalid.")
    @Pattern(regexp = "^.*@.*$", message = "Email format is invalid.")
    @EmailUnique(message = "Email already exists in database")
    private String email;

    //@NotNull
    @NotEmpty(message = "Password cannot be empty.")
    @Size(min = 8, max = 25, message = "Password must be between 8 and 25 characters.")
    @Pattern(regexp = "(?=.*[0-9]).+", message = "Password must contain at least on digit, 0 through 9.")
    @Pattern(regexp = "(?=.*[a-z]).+", message = "Password must contain at least one lowercase letter.")
    @Pattern(regexp = "(?=.*[A-Z]).+", message = "Password must contain at least one lowercase letter.")
    @Pattern(regexp = "(?=.*[!@#\\$%\\^&\\*]).+", message = "Password must contain at least one special character, ! @ # $ % ^ & *.")
    private String password;

    //@NotNull
    @NotEmpty(message = "Confirm Password cannot be empty.")
    private String confirmPassword;

    @NotEmpty(message = "Phone Number cannot be empty.")
    private String phone;

    @NotEmpty(message = "Address cannot be empty.")
    private String address;

    @NotEmpty(message = "City cannot be empty.")
    private String city;

    @NotEmpty(message = "State cannot be empty.")
    private String state;

    @NotEmpty(message = "Zip Code cannot be empty.")
    private String zipCode;

    // Constructors
    public CreateUser2Form() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "CreateUser2Form{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
