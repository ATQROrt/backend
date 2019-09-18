package com.ort.atqr.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@MappedSuperclass
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private Long document;
    private String mail;
    private Date birth;
    private String imageUrl;
    private String password;
    private Date createdAt;

    @OneToMany(targetEntity=Course.class, fetch= FetchType.EAGER)
    private Set<Course> courses;

    public User(String firstName, String lastName, Long document, String mail, Date birth, String imageUrl, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.document = document;
        this.mail = mail;
        this.birth = birth;
        this.imageUrl = imageUrl;
        this.password = password;
    }

    public User(){}

    @PrePersist
    private void createdAt(){
        this.createdAt = new Date();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

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

    public Long getId() {
        return id;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
