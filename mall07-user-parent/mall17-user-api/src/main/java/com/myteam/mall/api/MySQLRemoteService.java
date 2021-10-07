package com.myteam.mall.api;

import com.myteam.mall.entity.po.UserPO;
import com.myteam.mall.entity.vo.PortalCategoryVO;
import com.myteam.mall.util.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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

    /**
     * 根据用户id获取用户
     * @param userId
     * @return
     */
    @RequestMapping("/get/userpo/by/user/id/remote")
    ResultEntity<UserPO> getUserPOByUserId(@RequestParam("userId") Integer userId);

    /**
     * 获取首页显示商品分类信息
     * @return ResultEntity<List<PortalCategoryVO>>
     */
    @RequestMapping("/get/portal/category/data/remote")
    public ResultEntity<List<PortalCategoryVO>> getPortalCategoryDataRemote();
}
