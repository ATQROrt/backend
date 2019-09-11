package com.ort.atqr.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Entity
public class ClassDay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private List<Student> studentList;
    private Date date;
    private Boolean cancelled;

}
