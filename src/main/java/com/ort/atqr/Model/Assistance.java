package com.ort.atqr.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Assistance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private AssistanceStatus status;
    private Date date;
    private Student student;

}
