package com.myteam.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myteam.mall.entity.Complaint;
import com.myteam.mall.entity.ComplaintExample;
import com.myteam.mall.mapper.ComplaintMapper;
import com.myteam.mall.service.api.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintMapper complaintMapper;

    @Override
    public PageInfo<Complaint> getPageInfo(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        List<Complaint> complaints = complaintMapper.selectByKeyword(keyword);

        return new PageInfo<>(complaints);
    }

    @Override
    public void updateComplaintStatus(Integer id) {
        ComplaintExample example = new ComplaintExample();

        ComplaintExample.Criteria criteria = example.createCriteria();

        criteria.andIdEqualTo(id);

        Complaint complaint = new Complaint();

        complaint.setStatus("已处理");

        complaintMapper.updateByExampleSelective(complaint,example);

    }
}
