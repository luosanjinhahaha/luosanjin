package com.smxy.healthmedical.serviceImpl;

import com.smxy.healthmedical.bean.Media;
import com.smxy.healthmedical.dao.MediaMapper;
import com.smxy.healthmedical.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaServiceImpl implements MediaService {
	@Autowired
	MediaMapper mediaMapper;
	@Override
	public List<Media> getAll() {
		// TODO 自动生成的方法存根
		return mediaMapper.selectAll();
	}
	@Override
	public void delMediaById(Integer id) {
		// TODO 自动生成的方法存根	
		mediaMapper.deleteByPrimaryKey(id);
	}
	@Override
	public Media selectById(Integer id) {
		Media media = mediaMapper.selectByPrimaryKey(id);
		return media;
	}
	@Override
	public void updatemedia(Media media) {
		// TODO 自动生成的方法存根	
		mediaMapper.updateByPrimarySelective(media);
	}
}
