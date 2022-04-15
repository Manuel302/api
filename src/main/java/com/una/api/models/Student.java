package com.una.api.models;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class Student {
    private int id;
    private String password;
    private String email;
    private String name;
    private String phone;
    private int carreraIdcarrera;
    private Date birthdate;

    public Student() {
    }

    public Student(int id, String password, String email, String name, String phone, int carreraIdcarrera, Date birthdate) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.carreraIdcarrera = carreraIdcarrera;
        this.birthdate = birthdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCarreraIdcarrera() {
        return carreraIdcarrera;
    }

    public void setCarreraIdcarrera(int carreraIdcarrera) {
        this.carreraIdcarrera = carreraIdcarrera;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (carreraIdcarrera != student.carreraIdcarrera) return false;
        if (password != null ? !password.equals(student.password) : student.password != null) return false;
        if (email != null ? !email.equals(student.email) : student.email != null) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        if (phone != null ? !phone.equals(student.phone) : student.phone != null) return false;
        if (birthdate != null ? !birthdate.equals(student.birthdate) : student.birthdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + carreraIdcarrera;
        result = 31 * result + (birthdate != null ? birthdate.hashCode() : 0);
        return result;
    }
}
