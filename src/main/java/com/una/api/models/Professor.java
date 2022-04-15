package com.una.api.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Professor {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String password;

    public Professor() {
    }

    public Professor(int id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Professor profesor = (Professor) o;

        if (id != profesor.id) return false;
        if (name != null ? !name.equals(profesor.name) : profesor.name != null) return false;
        if (email != null ? !email.equals(profesor.email) : profesor.email != null) return false;
        if (phone != null ? !phone.equals(profesor.phone) : profesor.phone != null) return false;
        if (password != null ? !password.equals(profesor.password) : profesor.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
