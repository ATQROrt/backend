package com.ort.atqr.Model;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Assistance {

    private AssistanceStatus status;
    private Date date;
    private Student student;

}
