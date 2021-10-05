package com.myteam.mall.service.impl;

import com.myteam.mall.entity.po.UserPO;
import com.myteam.mall.entity.po.UserPOExample;
import com.myteam.mall.mapper.UserPOMapper;
import com.myteam.mall.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserPOMapper userPOMapper;

    @Override
    public UserPO getUserPOByUserAcct(String userAcct) {
        UserPOExample example = new UserPOExample();

        UserPOExample.Criteria criteria = example.createCriteria();

        criteria.andUserAcctEqualTo(userAcct);

        List<UserPO> list = userPOMapper.selectByExample(example);

        if (list == null || list.size() == 0){
            return null;
        }

        return list.get(0);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    @Override
    public void saveUser(UserPO userPO) {
        userPOMapper.insertSelective(userPO);
    }

}
