package com.myteam.mall.handler;

import com.myteam.mall.entity.po.ComplaintPO;
import com.myteam.mall.service.api.ComplaintService;
import com.myteam.mall.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComplaintProviderHandler {

    @Autowired
    private ComplaintService complaintService;

    @RequestMapping("/save/complaint/remote")
    ResultEntity<String> saveComplaintRemote(@RequestBody ComplaintPO complaintPO){
        complaintService.saveComplaintPO(complaintPO);
        return ResultEntity.successWithoutData();
    }
}
