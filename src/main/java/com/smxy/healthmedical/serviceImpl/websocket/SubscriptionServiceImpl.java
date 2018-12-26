package com.smxy.healthmedical.serviceImpl.websocket;

import com.smxy.healthmedical.bean.FastDfsDoc;
import com.smxy.healthmedical.dao.FastDfsDocMapper;
import com.smxy.healthmedical.service.websocket.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IDEA
 *
 * @author Luoxin
 * Date 2018/12/22
 * Time 18:15
 */
@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final FastDfsDocMapper fastDfsDocMapper;

    @Autowired
    public SubscriptionServiceImpl(FastDfsDocMapper fastDfsDocMapper) {
        this.fastDfsDocMapper = fastDfsDocMapper;
    }

    @Override
    public FastDfsDoc getFastDfsDocPathByInPath(Integer id) {

        return fastDfsDocMapper.getFastDfsDocInfoByInPath(id);

    }
}
