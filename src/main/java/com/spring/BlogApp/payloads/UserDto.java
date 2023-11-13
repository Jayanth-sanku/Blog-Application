package com.spring.BlogApp.payloads;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.validator.constraints.Email;
public class UserDto {



    private int id;

    @NotEmpty
    @Size(min = 3, message = "User name must be min of 3 characters")
    private String name;

    @Email(message = "Enter valid email address")
    private String email;

    @NotEmpty
    @Size(min = 3, message = "Password name must be min of 3 characters")
    private String password;

    @NotEmpty
    private String about;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public UserDto() {
    }
}
