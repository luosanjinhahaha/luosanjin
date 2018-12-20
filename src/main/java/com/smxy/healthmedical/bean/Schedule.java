package com.smxy.healthmedical.bean;

import java.util.Date;

public class Schedule {
    private Integer scheduleId;

    private Date scheduleTime;

    private String schedulePerson;

    private Integer sId;

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Date getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(Date scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public String getSchedulePerson() {
        return schedulePerson;
    }

    public void setSchedulePerson(String schedulePerson) {
        this.schedulePerson = schedulePerson == null ? null : schedulePerson.trim();
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }
}