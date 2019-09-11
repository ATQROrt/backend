package com.ort.atqr.Model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
public class Student extends User {

    private List<Asignature> asignatures;

    public Student(String firstName, String lastName, Long document, String mail, Date birth, String imageUrl, String password) {
        super(firstName, lastName, document, mail, birth, imageUrl, password);
    }
}
