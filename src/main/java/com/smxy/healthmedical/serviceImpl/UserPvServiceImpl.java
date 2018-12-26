package com.smxy.healthmedical.serviceImpl;

import com.smxy.healthmedical.bean.UserPv;
import com.smxy.healthmedical.dao.UserPvMapper;
import com.smxy.healthmedical.service.UserPvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IDEA
 * @author Luoxin
 * Date 2018/12/24
 * Time 17:00
 */
@Service
public class UserPvServiceImpl implements UserPvService {

    private final UserPvMapper userPvMapper;

    @Autowired
    public UserPvServiceImpl(UserPvMapper userPvMapper) {
        this.userPvMapper = userPvMapper;
    }

    @Override
    public void addUserPv(UserPv userPv) {

        userPvMapper.insertUserPvByPvName(userPv);

    }

    @Override
    public List<UserPv> findUserPvAll() {
        return userPvMapper.getUserPvAll();
    }

    @Override
    public UserPv findUserPvByExample(UserPv userPv) {
        return userPvMapper.getUserPvByNameAndModule(userPv);
    }

    @Override
    public void updatePvUserInfo(UserPv userPv) {
        userPvMapper.updateUserPv(userPv);
    }
}
