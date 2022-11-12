package ru.goltsov.springCRUD.models;

import javax.validation.constraints.*;

public class User {
    int id;
    @NotEmpty(message = "You have to add some name")
    @Size(min = 2, max = 20, message = "Wrong name length! Name should be between 2 & 20 characters. ")
    String name;
    @NotEmpty(message = "You have to add some surname")
    String surname;
    @Min(value = 0, message = "Age should be more than 0 ")
    @Max(value = 120, message = "Age very rare could be more than 120")
    int age;
    @NotEmpty(message = "Email should`nt be empty")
    @Email(message= "Email should be like this form - qqqq@ya.ru")
    String email;

    public User(int id, String name, String surname, int age, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
    }

    public User() {
    }

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
