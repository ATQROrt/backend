package com.ort.atqr.Models;

import java.math.BigDecimal;
import java.util.Date;

public class Student {

    private String firstName;
    private String lastName;
    private Long document;
    private String mail;
    private Date birth;
    private String imageUrl;
    private String password;

    public Student(String firstName, String lastName, Long document, String mail, Date birth, String imageUrl, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.document = document;
        this.mail = mail;
        this.birth = birth;
        this.imageUrl = imageUrl;
        this.password = password;
    }

    public Student() { }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getDocument() {
        return document;
    }

    public void setDocument(Long document) {
        this.document = document;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
