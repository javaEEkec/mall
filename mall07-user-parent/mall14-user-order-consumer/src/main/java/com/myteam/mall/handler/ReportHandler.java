package com.myteam.mall.handler;

import com.myteam.mall.api.MySQLRemoteService;
import com.myteam.mall.entity.po.ComplaintPO;
import com.myteam.mall.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReportHandler {

    @Autowired
    private MySQLRemoteService mySQLRemoteService;

    @ResponseBody
    @RequestMapping("do/commit/report")
    public ResultEntity<String> doCommitReport(ComplaintPO complaint){
        System.out.println(complaint);
        complaint.setStatus("待处理");
        ResultEntity<String> resultEntity = mySQLRemoteService.saveComplaintRemote(complaint);
        if (ResultEntity.FAILED.equals(resultEntity.getResult())){
            return ResultEntity.failed(resultEntity.getMessage());
        }
        return ResultEntity.successWithoutData();
    }
}
