package com.nitin.springrest.entities;

public class Course
{

    private int id;

    private String title;
    private String Desc;


    public Course(int id, String title, String desc) {
        this.id = id;
        Desc = desc;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
