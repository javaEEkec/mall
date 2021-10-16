package com.myteam.mall.service.impl;

import com.myteam.mall.entity.po.ComplaintPO;
import com.myteam.mall.mapper.ComplaintPOMapper;
import com.myteam.mall.service.api.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintPOMapper complaintPOMapper;

    @Override
    public void saveComplaintPO(ComplaintPO complaintPO) {
        complaintPOMapper.insert(complaintPO);
    }
}
