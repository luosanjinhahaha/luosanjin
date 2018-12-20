package com.smxy.healthmedical.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
@Service
public interface UploadService {
	public void upload(HttpServletRequest request, HttpServletResponse response);
}
