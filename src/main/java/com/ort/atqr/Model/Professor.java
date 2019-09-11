package com.ort.atqr.Model;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@Entity
public class Professor extends User{

    private List<Course> courses;

    public Professor(String firstName, String lastName, Long document, String mail, Date birth, String imageUrl, String password) {
        super(firstName, lastName, document, mail, birth, imageUrl, password);
    }
}
