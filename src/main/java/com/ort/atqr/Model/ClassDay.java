package com.ort.atqr.Model;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@Entity
public class ClassDay {

    private List<Student> studentList;
    private Date date;
    private Boolean cancelled;

}
