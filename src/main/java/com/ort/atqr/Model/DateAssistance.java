package com.ort.atqr.Model;

import java.util.Date;

public class DateAssistance {

    private Date date;
    private AssistanceStatus assistanceStatus;
    private Boolean cancelled;

    public DateAssistance(Date date, AssistanceStatus assistanceStatus, Boolean cancelled) {
        this.date = date;
        this.assistanceStatus = assistanceStatus;
        this.cancelled = cancelled;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AssistanceStatus getAssistanceStatus() {
        return assistanceStatus;
    }

    public void setAssistanceStatus(AssistanceStatus assistance) {
        this.assistanceStatus = assistance;
    }

    public Boolean getCancelled() {
        return cancelled;
    }

    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
    }
}
