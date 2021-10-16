package com.myteam.mall.service.api;

import com.github.pagehelper.PageInfo;
import com.myteam.mall.entity.Complaint;

public interface ComplaintService {
    PageInfo<Complaint> getPageInfo(String keyword, Integer pageNum, Integer pageSize);

    void updateComplaintStatus(Integer id);
}
