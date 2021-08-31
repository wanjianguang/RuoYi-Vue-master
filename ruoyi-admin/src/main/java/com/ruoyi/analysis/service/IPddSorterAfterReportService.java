package com.ruoyi.analysis.service;

import java.util.List;

import com.ruoyi.analysis.domain.PddSorterAfterReport;

/**
 * 分拣员售后报表Service接口
 * 
 * @author wonderful
 * @date 2021-08-14
 */
public interface IPddSorterAfterReportService 
{
    /**
     * 分拣员售后-统计数据
     */
	public List<PddSorterAfterReport> selectPddSorterAfterReportList(String pickUpDate);
}
