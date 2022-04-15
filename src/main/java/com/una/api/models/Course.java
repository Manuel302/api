package com.una.api.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Course {
    private String name;
    private int credits;
    private int weeklyHours;
    private String id;
    private int careerId;
    private int year;
    private String cycle;

    public Course() {
    }

    public Course(String name, int credits, int weeklyHours, String id, int careerId, int year, String cycle) {
        this.name = name;
        this.credits = credits;
        this.weeklyHours = weeklyHours;
        this.id = id;
        this.careerId = careerId;
        this.year = year;
        this.cycle = cycle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getWeeklyHours() {
        return weeklyHours;
    }

    public void setWeeklyHours(int weeklyHours) {
        this.weeklyHours = weeklyHours;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCareerId() {
        return careerId;
    }

    public void setCareerId(int careerId) {
        this.careerId = careerId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }
}
