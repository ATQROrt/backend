package com.ort.atqr.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Student extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(targetEntity=Asignature.class, fetch= FetchType.EAGER)
    private Set<Asignature> asignatures;

    public Student(String firstName, String lastName, Long document, String mail, Date birth, String imageUrl, String password) {
        super(firstName, lastName, document, mail, birth, imageUrl, password);
    }
}
