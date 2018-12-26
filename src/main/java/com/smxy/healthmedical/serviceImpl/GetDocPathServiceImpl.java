package com.smxy.healthmedical.serviceImpl;

import com.smxy.healthmedical.bean.FastDfsDoc;
import com.smxy.healthmedical.dao.FastDfsDocMapper;
import com.smxy.healthmedical.service.GetDocPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IDEA
 *
 * @author Luoxin
 * Date 2018/11/15
 * Time 20:32
 */
@Service
public class GetDocPathServiceImpl implements GetDocPathService {

    private final FastDfsDocMapper fastDfsDocMapper;

    @Autowired
    public GetDocPathServiceImpl(FastDfsDocMapper fastDfsDocMapper) {
        this.fastDfsDocMapper = fastDfsDocMapper;
    }


    @Override
    public List<FastDfsDoc> getDocPathAll() {
        return fastDfsDocMapper.getDocPath();
    }

    @Override
    public void saveDocPath(FastDfsDoc fastDfsDoc) {

        fastDfsDocMapper.insertDocPath(fastDfsDoc);
    }

    @Override
    public void deleteDocByPath(String oldPath) {
        fastDfsDocMapper.deleteDoc(oldPath);
    }
}
