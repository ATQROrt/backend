package com.ort.atqr.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class ClassDay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Student> studentList;
    private Date date;
    private Boolean cancelled;

}
