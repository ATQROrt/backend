package com.ort.atqr.Model;

import javax.persistence.*;
import java.util.Date;

public class Assistance {
    private Long id;
    private AssistanceStatus status;
    private Date date;
    private Student student;

}
