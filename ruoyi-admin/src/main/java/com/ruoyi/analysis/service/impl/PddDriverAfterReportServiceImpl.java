package com.ruoyi.analysis.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.analysis.domain.PddDriverAfterReport;
import com.ruoyi.analysis.mapper.PddDriverAfterReportMapper;
import com.ruoyi.analysis.service.IPddDriverAfterReportService;

/**
 * 司机售后报表Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-08-14
 */
@Service
public class PddDriverAfterReportServiceImpl implements IPddDriverAfterReportService 
{

    @Autowired
    private PddDriverAfterReportMapper pddDriverAfterReportMapper;
    
	@Override
	public List<PddDriverAfterReport> selectPddDriverAfterReportList(Date pickUpDate) {

		return pddDriverAfterReportMapper.selectPddDriverAfterReportList(pickUpDate);
	}

}
