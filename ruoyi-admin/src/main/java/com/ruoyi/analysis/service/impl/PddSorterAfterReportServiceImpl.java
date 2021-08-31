package com.ruoyi.analysis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.analysis.domain.PddSorterAfterReport;
import com.ruoyi.analysis.mapper.PddSorterAfterReportMapper;
import com.ruoyi.analysis.service.IPddSorterAfterReportService;

/**
 * 分拣员售后报表Service业务层处理
 * 
 * @author wonderful
 * @date 2021-08-14
 */
@Service
public class PddSorterAfterReportServiceImpl implements IPddSorterAfterReportService 
{

    @Autowired
    private PddSorterAfterReportMapper pddSorterAfterReportMapper;
    
	@Override
	public List<PddSorterAfterReport> selectPddSorterAfterReportList(String pickUpDate) {

		return pddSorterAfterReportMapper.selectPddSorterAfterReportList(pickUpDate);
	}

}
