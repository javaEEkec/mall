package com.myteam.mall.api;

import com.myteam.mall.entity.po.UserPO;
import com.myteam.mall.util.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("myteam-mall-mysql")
public interface MySQLRemoteService {

    @RequestMapping("/get/userpo/by/user/acct/remote")
    ResultEntity<UserPO> getUserPOByUserAcctRemote(@RequestParam("userAcct") String userAcct);

    /**
     * 保存用户
     * @param userPO 用户的持久化数据
     * @return
     */
    @RequestMapping("/save/user/remote")
    ResultEntity<String> saveUser(@RequestBody UserPO userPO);
}
