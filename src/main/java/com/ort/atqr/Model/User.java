package com.ort.atqr.Model;

import com.ort.atqr.Exception.ErrorMessage;
import com.ort.atqr.Exception.InvalidInputException;

import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
public abstract class User implements Validatable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Access(AccessType.PROPERTY)
    private Long id;
    private String firstName;
    private String lastName;
    private Long document;
    private String mail;
    private LocalDate birth;
    private String imageUrl;
    private String password;
    private LocalDate createdAt;
    @Column(name = "IS_ADMIN", columnDefinition = "boolean default false", nullable = false)
    private Boolean isAdmin = false;

    public User(String firstName, String lastName, Long document, String mail, LocalDate birth, String imageUrl, String password, Boolean isAdmin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.document = document;
        this.mail = mail;
        this.birth = birth;
        this.imageUrl = imageUrl;
        this.password = password;
        this.isAdmin = isAdmin;
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

        if (this.birth == null || this.birth.isBefore(LocalDate.of(1990, 1, 1)) || this.birth.isAfter(LocalDate.now())) {
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
        this.createdAt = LocalDate.now();
    }

    public LocalDate getCreatedAt() {
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

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
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

    public Boolean getIsAdmin() {
        return isAdmin;
    }
}
