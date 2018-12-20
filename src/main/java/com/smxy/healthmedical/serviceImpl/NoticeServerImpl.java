package com.smxy.healthmedical.serviceImpl;

import com.smxy.healthmedical.bean.Notice;
import com.smxy.healthmedical.dao.NoticeMapper;
import com.smxy.healthmedical.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServerImpl implements NoticeService {
	@Autowired
	NoticeMapper noticeMapper;
	@Override
	public List<Notice> getAll() {
		// TODO 自动生成的方法存根
		return noticeMapper.selectAll();
	}
	@Override
	public void delNoticeById(Integer id) {
		// TODO 自动生成的方法存根	
		noticeMapper.deleteByPrimaryKey(id);
	}
	@Override
	public Notice selectById(Integer id) {
		Notice notice = noticeMapper.selectByPrimaryKey(id);
		return notice;
	}
	@Override
	public void updatenotice(Notice notice) {
		// TODO 自动生成的方法存根	
		noticeMapper.updateByPrimarySelective(notice);
	}	
}
