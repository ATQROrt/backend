package com.ort.atqr.Model;

import com.ort.atqr.Exception.ErrorMessage;
import com.ort.atqr.Exception.InvalidInputException;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@MappedSuperclass
public abstract class User implements Validatable {
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

    @OneToMany(targetEntity = Course.class, fetch = FetchType.EAGER)
    private List<Course> courses;

    public User(String firstName, String lastName, Long document, String mail, Date birth, String imageUrl, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.document = document;
        this.mail = mail;
        this.birth = birth;
        this.imageUrl = imageUrl;
        this.password = password;
    }

    public User() {
    }

    @Override
    public void validate() throws InvalidInputException {
        if (this.firstName == null || this.firstName.isEmpty()) {
            throw new InvalidInputException(ErrorMessage.INVALID_NAME);
        }

        if (this.lastName == null || this.lastName.isEmpty()) {
            throw new InvalidInputException(ErrorMessage.INVALID_LAST_NAME);
        }

        if (this.document == null || this.document < 1) {
            throw new InvalidInputException(ErrorMessage.INVALID_DOCUMENT);
        }

        if (this.birth == null || this.birth.before(new Date(111900)) || this.birth.after(new Date())) {
            throw new InvalidInputException(ErrorMessage.INVALID_BIRTHDATE);
        }

        if (this.getMail() == null || !this.getMail().contains("@")) {
            throw new InvalidInputException(ErrorMessage.INVALID_MAIL);
        }

        if (this.password == null || this.password.length() < 8 || this.password.length() > 16) {
            throw new InvalidInputException(ErrorMessage.INVALID_PASSWORD);
        }
    }

    @PrePersist
    private void createdAt() {
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

    public void setId(Long id) {
        this.id = id;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
