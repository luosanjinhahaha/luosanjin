package com.smxy.healthmedical.service;

import com.smxy.healthmedical.bean.Notice;

import java.util.List;
public interface NoticeService {
	public List<Notice> getAll();
	public void delNoticeById(Integer id);
	public Notice selectById(Integer id);
	public void updatenotice(Notice notice);
}
