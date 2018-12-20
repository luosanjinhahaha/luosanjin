package com.smxy.healthmedical.serviceImpl;

import com.smxy.healthmedical.bean.FastDfsImg;
import com.smxy.healthmedical.dao.FastDfsImgMapper;
import com.smxy.healthmedical.service.GetImgPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IDEA
 *
 * @author Luoxin
 * Date 2018/11/15
 * Time 20:32
 */
@Service("getImgPathService")
public class GetImgPathServiceImpl implements GetImgPathService {

    @Autowired
    FastDfsImgMapper fastDfsImgMapper;
    @Override
    public List<FastDfsImg> getImgPathAll() {
        return fastDfsImgMapper.getImgPath();
    }

    @Override
    public void ImgPath(FastDfsImg fastDfsImg) {
        fastDfsImgMapper.insertImgPath(fastDfsImg);
    }

    @Override
    public void deleteImgByPath(String oldPath) {
        fastDfsImgMapper.deleteImg(oldPath);
    }
}
