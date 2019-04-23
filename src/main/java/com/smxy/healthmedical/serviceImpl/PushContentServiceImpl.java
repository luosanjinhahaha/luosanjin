package com.smxy.healthmedical.serviceImpl;

import com.smxy.healthmedical.bean.PushContent;
import com.smxy.healthmedical.dao.PushContentMapper;
import com.smxy.healthmedical.service.PushContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IDEA
 *
 * @author Luoxin
 * Date 2018/12/29
 * Time 10:15
 */
@Service
public class PushContentServiceImpl implements PushContentService {

    private final PushContentMapper pushContentMapper;

    @Autowired
    public PushContentServiceImpl(PushContentMapper pushContentMapper) {
        this.pushContentMapper = pushContentMapper;
    }

    @Override
    public List<PushContent> getPushContentAll() {

        return pushContentMapper.selectPushContentAll();
    }
}
