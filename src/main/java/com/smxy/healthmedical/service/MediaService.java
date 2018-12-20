package com.smxy.healthmedical.service;

import com.smxy.healthmedical.bean.Media;

import java.util.List;
public interface MediaService {
	public List<Media> getAll();
	public void delMediaById(Integer id);
	public Media selectById(Integer id);
	public void updatemedia(Media media);
}
