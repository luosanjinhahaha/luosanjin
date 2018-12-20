package com.smxy.healthmedical.serviceImpl;

import com.smxy.healthmedical.bean.Appoint;
import com.smxy.healthmedical.dao.AppointMapper;
import com.smxy.healthmedical.service.AppointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IDEA
 * author:Luoxin
 * Date:2018/10/18
 * Time:16:19
 */
@Service
public class AppointServiceImpl implements AppointService {

    @Autowired
    AppointMapper appointMapper;
    @Override
    public List<Appoint> getUserAll() {
        return appointMapper.getAll();
    }

    @Override
    public void insert(Appoint appoint) {
        appointMapper.insertAppoint(appoint);
    }
}
