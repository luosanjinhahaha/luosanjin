package com.smxy.healthmedical.service;

import com.smxy.healthmedical.bean.DoctorAppoint;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

public interface DoctorAppointService {

    void insertDoctorAppointInfo(DoctorAppoint doctorAppoint);

    void insertDoctorAppointIntoRabbitmq(DoctorAppoint doctorAppoint) throws URISyntaxException, KeyManagementException, TimeoutException, NoSuchAlgorithmException, IOException;
}
