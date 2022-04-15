package com.una.api.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Career {
    private int id;
    private String name;
    private String tittle;

    public Career() {
    }

    public Career(int id, String name, String tittle) {
        this.id = id;
        this.name = name;
        this.tittle = tittle;
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

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Career career = (Career) o;

        if (id != career.id) return false;
        if (name != null ? !name.equals(career.name) : career.name != null) return false;
        if (tittle != null ? !tittle.equals(career.tittle) : career.tittle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (tittle != null ? tittle.hashCode() : 0);
        return result;
    }
}
