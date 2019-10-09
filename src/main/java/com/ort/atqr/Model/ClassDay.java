package com.ort.atqr.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class ClassDay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private AssistanceStatus assistanceStatus;
    private Date date;
    private Boolean cancelled;

    public Long getId() {
        return id;
    }

    public AssistanceStatus getAssistanceStatus() {
        return assistanceStatus;
    }

    public void setAssistanceStatus(AssistanceStatus assistanceStatus) {
        this.assistanceStatus = assistanceStatus;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getCancelled() {
        return cancelled;
    }

    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
    }
}
