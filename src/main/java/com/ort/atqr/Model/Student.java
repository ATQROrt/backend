package com.ort.atqr.Model;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Student extends User {

    public Student(String firstName, String lastName, Long document, String mail, LocalDate birth, String imageUrl, String password) {
        super(firstName, lastName, document, mail, birth, imageUrl, password, false);
    }

    public Student() {
    }

    @Override
    public boolean equals(Object obj) {
        Student student = (Student) obj;
        return this.getId().equals(student.getId());
    }
}
