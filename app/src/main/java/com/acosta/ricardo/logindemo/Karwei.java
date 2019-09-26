package com.acosta.ricardo.logindemo;

import android.provider.Settings;

public class Karwei {

    private String title;
    private String description;
    private String contact;
    private String  wage;
    //DEVICE ID
    private String id;


    //CONSTRUCTOR
    public Karwei(String title, String description, String contact, String wage, String id) {
        this.title = title;
        this.description = description;
        this.contact = contact;
        this.wage = wage;
        this.id = id;


    }
    //CONSTRUCTOR
    public Karwei() {
    }

    //GETTERS & SETTERS
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getWage() {
        return wage;
    }

    public void setWage(String wage) {
        this.wage = wage;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

}
