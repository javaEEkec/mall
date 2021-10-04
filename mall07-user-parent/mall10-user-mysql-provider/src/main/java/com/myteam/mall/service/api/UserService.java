package com.myteam.mall.service.api;

import com.myteam.mall.entity.po.UserPO;

public interface UserService {

    UserPO getUserPOByUserAcct(String userAcct);

    void saveUser(UserPO userPO);
}
