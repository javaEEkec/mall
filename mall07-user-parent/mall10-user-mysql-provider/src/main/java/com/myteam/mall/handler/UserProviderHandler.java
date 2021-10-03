package com.myteam.mall.handler;

import com.myteam.mall.entity.po.UserPO;
import com.myteam.mall.service.api.UserService;
import com.myteam.mall.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ljs
 */
@RestController
public class UserProviderHandler {

    @Autowired
    private UserService userService;

    @RequestMapping("/get/userpo/by/user/acct/remote")
    ResultEntity<UserPO> getUserPOByUserAcctRemote(@RequestParam("userAcct") String userAcct){
        UserPO userPO = null;

        try {
            // 1.调用本地Service完成查询
            userPO = userService.getUserPOByUserAcct(userAcct);
            // 2.成功则返回结果
            return ResultEntity.successWithData(userPO);
        } catch (Exception e) {
            e.printStackTrace();
            // 3. 异常则返回异常信息
            return ResultEntity.failed(e.getMessage());
        }
    }
}
