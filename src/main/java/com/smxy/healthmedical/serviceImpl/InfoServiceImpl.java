package com.smxy.healthmedical.serviceImpl;

import com.smxy.healthmedical.bean.Info;
import com.smxy.healthmedical.bean.InfoExample;
import com.smxy.healthmedical.dao.InfoMapper;
import com.smxy.healthmedical.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoServiceImpl implements InfoService {

	@Autowired
	InfoMapper infoMapper;

	@Override
//	@Cacheable(cacheNames = "allInfo",key = "info")
	public List<Info> getAll() {

		System.out.println("还在从数据库查询！");

		List<Info> infolistInfo = infoMapper.selectAllWithDept(null);

//		stringRedisTemplate.opsForValue().set("allInfo", String.valueOf(infolistInfo));

		return infolistInfo;
	}

	public void savePatients(Info info) {
		infoMapper.insertSelective(info);
	}

	@Override
	public boolean checkpatients(String pinfoName) {

		InfoExample infoExample = new InfoExample();

		InfoExample.Criteria criteria = infoExample.createCriteria();

		criteria.andPinfoNameEqualTo(pinfoName);

		Long count = infoMapper.countByExample(infoExample);

		return count==0;
	}

	@Override
	public Info getPatients(Integer id) {

		Info info = infoMapper.selectByPrimaryKeyWithDept(id);

		return info;
	}

//	@CachePut(cacheNames = "allInfo")
	@Override
	public Info UpdatePatients(Info info) {

		System.out.println("更新缓存");

		infoMapper.updateByPrimaryKeySelective(info);

		System.out.println(info);

		return info;
	}

	@Override
	public void delPatientsById(Integer id) {

		infoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteBatch(List<Integer> ids) {

		InfoExample infoExample = new InfoExample();

		InfoExample.Criteria criteria = infoExample.createCriteria();

		criteria.andPinfoIdIn(ids);

		infoMapper.deleteByExample(infoExample);
	}

	@Override
	public List<Info> searchPatients(Info info, String search) {

		InfoExample infoExample = new InfoExample();

		InfoExample.Criteria criteria = infoExample.createCriteria();

		if(search!=null && !"".equals(info.getPinfoName())){

			criteria.andPinfoNameLike("%"+search+"%");

			return infoMapper.selectByExampleWithDept(infoExample);
		}

		else if(search!=null && !"".equals(info.getPpinfoIllname())){

			criteria.andPpinfoIllnameLike("%"+search+"%");

			return infoMapper.selectByExampleWithDept(infoExample);
		}

		return infoMapper.selectByExampleWithDept(infoExample);
	}

	@Override
	public Integer[] getAllInfoPiId() {
		return infoMapper.countInfoPiId();
	}

	@Override
	public List<Info> getInfoByPiId(Integer piId) {
		return infoMapper.selectInfoByPiId(piId);
	}

}
