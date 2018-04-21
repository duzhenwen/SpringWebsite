
package com.example.springdemo.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name="person")
public class Person {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String name;
    @Column
    private String email;
     @Column
    private String telephone;
    @Column
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Person() {
    }

}

