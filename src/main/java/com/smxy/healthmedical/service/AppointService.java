package com.smxy.healthmedical.service;

import com.smxy.healthmedical.bean.Appoint;

import java.util.List;

public interface AppointService {
    public List<Appoint> getUserAll();
    void insert(Appoint appoint);
}
