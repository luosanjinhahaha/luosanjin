package com.smxy.healthmedical.service;

import com.smxy.healthmedical.bean.Customization;
import com.smxy.healthmedical.bean.FastDfsDoc;

import java.util.List;

public interface CustomizationService {
    void insertCustomizationInfo(Customization customization);

    List<FastDfsDoc> getCustomDetails(String customDetails);
}
