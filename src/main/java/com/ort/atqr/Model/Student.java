package com.ort.atqr.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Student extends User {
    @OneToMany(targetEntity=Asignature.class, fetch= FetchType.EAGER)
    private Set<Asignature> asignatures;

    public Student(String firstName, String lastName, Long document, String mail, Date birth, String imageUrl, String password) {
        super(firstName, lastName, document, mail, birth, imageUrl, password);
    }


}
