package com.myteam.mall.mvc.handler;

import com.github.pagehelper.PageInfo;
import com.myteam.mall.entity.Complaint;
import com.myteam.mall.service.api.ComplaintService;
import com.myteam.mall.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComplaintHandler {

    @Autowired
    private ComplaintService complaintService;

    @RequestMapping("get/complaint/page/info.json")
    public ResultEntity<PageInfo<Complaint>> getComplaintPageInfo(
            @RequestParam(value = "keyword", defaultValue = "") String keyword,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize
    ){
        PageInfo<Complaint> pageInfo = complaintService.getPageInfo(keyword, pageNum, pageSize);
        return ResultEntity.successWithData(pageInfo);
    }

    @RequestMapping("update/complaint/status.json")
    public ResultEntity<String> updateComplaintStatus(@RequestParam("id") Integer id){
        complaintService.updateComplaintStatus(id);
        return ResultEntity.successWithoutData();
    }

}
