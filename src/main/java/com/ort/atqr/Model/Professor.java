package com.ort.atqr.Model;

import java.util.Date;
import java.util.Set;

public class Professor extends User{
    private Long id;
    private Set<Course> courses;

    public Professor(String firstName, String lastName, Long document, String mail, Date birth, String imageUrl, String password) {
        super(firstName, lastName, document, mail, birth, imageUrl, password);
    }
}
