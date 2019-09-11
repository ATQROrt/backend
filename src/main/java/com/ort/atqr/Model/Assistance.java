package com.ort.atqr.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Assistance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private AssistanceStatus status;
    private Date date;
    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private Student student;

}
