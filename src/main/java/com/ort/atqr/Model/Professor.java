package com.ort.atqr.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Professor extends User{
    @OneToMany(targetEntity=Course.class, fetch= FetchType.EAGER)
    private Set<Course> courses;

    public Professor(String firstName, String lastName, Long document, String mail, Date birth, String imageUrl, String password) {
        super(firstName, lastName, document, mail, birth, imageUrl, password);
    }
}
