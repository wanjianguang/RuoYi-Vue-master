package com.ruoyi.analysis.service;

import java.util.List;

import com.ruoyi.analysis.domain.PddDriverAfterReport;

/**
 * 司机售后报表Service接口
 * 
 * @author wonderful
 * @date 2021-08-14
 */
public interface IPddDriverAfterReportService 
{
    /**
     * 查出司机售后-统计数据
     */
	public List<PddDriverAfterReport> selectPddDriverAfterReportList(String pickUpDate);
}
