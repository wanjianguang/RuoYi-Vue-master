package com.ruoyi.analysis.mapper;

import java.util.List;

import com.ruoyi.analysis.domain.PddSorterAfterReport;

/**
 * 分拣员售后报表Mapper接口
 * 
 * @author wonderful
 * @date 2021-08-14
 */
public interface PddSorterAfterReportMapper 
{
    
    /**
     * 查询司机售后报表列表
     * 
     * @param pddDriverAfter 司机售后报表
     * @return 司机售后报表集合
     */
    public List<PddSorterAfterReport> selectPddSorterAfterReportList(String pickUpDate);
}
