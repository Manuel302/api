package com.una.api.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Enrollment {
    private int group;
    private int student;
    private String note;


    public Enrollment() {
    }

    public Enrollment(int group, int student, String note) {
        this.group = group;
        this.student = student;
        this.note = note;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getStudent() {
        return student;
    }

    public void setStudent(int student) {
        this.student = student;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
