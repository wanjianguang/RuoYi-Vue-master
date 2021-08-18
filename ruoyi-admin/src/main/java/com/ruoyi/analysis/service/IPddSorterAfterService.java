package com.ruoyi.analysis.service;

import java.util.List;
import com.ruoyi.analysis.domain.PddSorterAfter;

/**
 * 分拣员售后报Service接口
 * 
 * @author wonderful
 * @date 2021-08-17
 */
public interface IPddSorterAfterService 
{
    /**
     * 查询分拣员售后报
     * 
     * @param storeId 分拣员售后报主键
     * @return 分拣员售后报
     */
    public PddSorterAfter selectPddSorterAfterByStoreId(String storeId);

    /**
     * 查询分拣员售后报列表
     * 
     * @param pddSorterAfter 分拣员售后报
     * @return 分拣员售后报集合
     */
    public List<PddSorterAfter> selectPddSorterAfterList(PddSorterAfter pddSorterAfter);

    /**
     * 新增分拣员售后报
     * 
     * @param pddSorterAfter 分拣员售后报
     * @return 结果
     */
    public int insertPddSorterAfter(PddSorterAfter pddSorterAfter);

    /**
     * 修改分拣员售后报
     * 
     * @param pddSorterAfter 分拣员售后报
     * @return 结果
     */
    public int updatePddSorterAfter(PddSorterAfter pddSorterAfter);

    /**
     * 批量删除分拣员售后报
     * 
     * @param storeIds 需要删除的分拣员售后报主键集合
     * @return 结果
     */
    public int deletePddSorterAfterByStoreIds(String[] storeIds);

    /**
     * 删除分拣员售后报信息
     * 
     * @param storeId 分拣员售后报主键
     * @return 结果
     */
    public int deletePddSorterAfterByStoreId(String storeId);
}
