package com.myteam.mall.handler;

import com.myteam.mall.constant.MallConstant;
import com.myteam.mall.entity.po.UserPO;
import com.myteam.mall.service.api.UserService;
import com.myteam.mall.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping("/save/user/remote")
    private ResultEntity<String> saveUser(@RequestBody UserPO userPO){

        try {
            userService.saveUser(userPO);
            return ResultEntity.successWithoutData();
        } catch (Exception e) {
            if (e instanceof DuplicateKeyException){
                return ResultEntity.failed(MallConstant.MESSAGE_LOGIN_ACCT_ALREADY_IN_USE);
            }
            return ResultEntity.failed(e.getMessage());
        }
    }

    @RequestMapping("/get/userpo/by/user/acct/remote")
    ResultEntity<UserPO> getUserPOByUserAcctRemote(@RequestParam("userAcct") String userAcct){
        UserPO userPO;
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
    @RequestMapping("/get/userpo/by/user/id/remote")
    ResultEntity<UserPO> getUserPOByUserId(@RequestParam("userId") Integer userId){
        UserPO userPO;
        try{
            userPO = userService.getUserPOByUserId(userId);
            return ResultEntity.successWithData(userPO);
        }catch (Exception e){
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
    }
}
