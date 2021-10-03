package com.myteam.mall.api;

import com.myteam.mall.entity.po.UserPO;
import com.myteam.mall.util.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("myteam-mall-mysql")
public interface MySQLRemoteService {

    @RequestMapping("/get/userpo/by/user/acct/remote")
    ResultEntity<UserPO> getUserPOByUserAcctRemote(@RequestParam("userAcct") String userAcct);

}
