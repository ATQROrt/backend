package com.ort.atqr.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class ClassDay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(targetEntity=Student.class, fetch= FetchType.EAGER)
    private Set<Student> studentList;
    private Date date;
    private Boolean cancelled;

}
