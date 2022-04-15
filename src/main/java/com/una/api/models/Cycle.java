package com.una.api.models;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class Cycle {
    private int id;
    private int year;
    private int number;
    private Date statDate;
    private Date endData;

    public Cycle() {
    }

    public Cycle(int id, int year, int number, Date statDate, Date endData) {
        this.id = id;
        this.year = year;
        this.number = number;
        this.statDate = statDate;
        this.endData = endData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getStatDate() {
        return statDate;
    }

    public void setStatDate(Date statDate) {
        this.statDate = statDate;
    }

    public Date getEndData() {
        return endData;
    }

    public void setEndData(Date endData) {
        this.endData = endData;
    }
}
