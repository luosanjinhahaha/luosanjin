package com.smxy.healthmedical.serviceImpl;

import com.smxy.healthmedical.bean.Customization;
import com.smxy.healthmedical.dao.CustomizationMapper;
import com.smxy.healthmedical.service.CustomizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public void insertCustomizationInfo(Customization customization) {
        customizationMapper.insertCustomization(customization);
    }
}
