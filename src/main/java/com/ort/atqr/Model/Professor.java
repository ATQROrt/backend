package com.ort.atqr.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Professor extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private List<Course> courses;

    public Professor(String firstName, String lastName, Long document, String mail, Date birth, String imageUrl, String password) {
        super(firstName, lastName, document, mail, birth, imageUrl, password);
    }
}
