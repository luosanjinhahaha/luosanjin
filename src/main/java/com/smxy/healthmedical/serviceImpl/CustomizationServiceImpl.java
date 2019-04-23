package com.smxy.healthmedical.serviceImpl;

import com.smxy.healthmedical.bean.Customization;
import com.smxy.healthmedical.bean.FastDfsDoc;
import com.smxy.healthmedical.dao.CustomizationMapper;
import com.smxy.healthmedical.dao.FastDfsDocMapper;
import com.smxy.healthmedical.service.CustomizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.Oneway;
import java.util.List;

/**
 * Created with IDEA
 * @author:Luoxin
 * Date:2018/10/22
 * Time:10:44
 */
@Service
public class CustomizationServiceImpl implements CustomizationService {
    @Autowired
    CustomizationMapper customizationMapper;

    @Autowired
    FastDfsDocMapper fastDfsDocMapper;

    @Override
    public void insertCustomizationInfo(Customization customization) {
        customizationMapper.insertCustomization(customization);
    }

    /**
     *
     * @param customDetails
     * @return
     */
    @Override
    public List<FastDfsDoc> getCustomDetails(String customDetails) {
        List<FastDfsDoc> fastDfsDocs = fastDfsDocMapper.selectCustomDetails(customDetails);
        return fastDfsDocs;
    }
}
