package com.ruoyi.analysis.mapper;

import java.util.Date;
import java.util.List;

import com.ruoyi.analysis.domain.PddDriverAfterReport;

/**
 * 司机售后报表Mapper接口
 * 
 * @author ruoyi
 * @date 2021-08-14
 */
public interface PddDriverAfterReportMapper 
{
    
    /**
     * 查询司机售后报表列表
     * 
     * @param pddDriverAfter 司机售后报表
     * @return 司机售后报表集合
     */
    public List<PddDriverAfterReport> selectPddDriverAfterReportList(String pickUpDate);
}
