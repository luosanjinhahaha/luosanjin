package com.smxy.healthmedical.dao;

import com.smxy.healthmedical.bean.Appoint;

import java.util.List;

/**
 * @author:luoxin
 */
public interface AppointMapper {
    /**
     * fetch data by rule id
     * @return
     */
    List<Appoint> getAll();
    void insertAppoint(Appoint appoint);
}
