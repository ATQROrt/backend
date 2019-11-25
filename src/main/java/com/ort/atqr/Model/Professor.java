package com.ort.atqr.Model;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Professor extends User {
    public Professor(String firstName, String lastName, Long document, String mail, LocalDate birth, String imageUrl, String password, Boolean isAdmin) {
        super(firstName, lastName, document, mail, birth, imageUrl, password, isAdmin);
    }

    public Professor(String firstName, String lastName, Long document, String mail, LocalDate birth, String imageUrl, String password) {
        super(firstName, lastName, document, mail, birth, imageUrl, password, false);
    }

    public Professor() {
    }
}
