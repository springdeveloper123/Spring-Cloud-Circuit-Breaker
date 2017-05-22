package com.spring.student.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Student {

    private String name;
    private String location;
    private int id;
    private String education;
    private Marks mark;

    public Student(int id, String name, String education, String location,
            Marks mark) {
        super();
        this.name = name;
        this.location = location;
        this.id = id;
        this.education = education;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getEducation() {
        return education;
    }
    public void setEducation(String education) {
        this.education = education;
    }
    public Marks getMark() {
        return mark;
    }
    public void setMark(Marks mark) {
        this.mark = mark;
    }
}
