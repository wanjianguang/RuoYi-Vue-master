package com.ruoyi.analysis.service;

import java.util.List;
import com.ruoyi.analysis.domain.PddDriverAfter;

/**
 * 司机售后报表Service接口
 * 
 * @author ruoyi
 * @date 2021-08-14
 */
public interface IPddDriverAfterService 
{
    /**
     * 查询司机售后报表
     * 
     * @param id 司机售后报表主键
     * @return 司机售后报表
     */
    public PddDriverAfter selectPddDriverAfterById(Long id);

    /**
     * 查询司机售后报表列表
     * 
     * @param pddDriverAfter 司机售后报表
     * @return 司机售后报表集合
     */
    public List<PddDriverAfter> selectPddDriverAfterList(PddDriverAfter pddDriverAfter);

    /**
     * 新增司机售后报表
     * 
     * @param pddDriverAfter 司机售后报表
     * @return 结果
     */
    public int insertPddDriverAfter(PddDriverAfter pddDriverAfter);

    /**
     * 修改司机售后报表
     * 
     * @param pddDriverAfter 司机售后报表
     * @return 结果
     */
    public int updatePddDriverAfter(PddDriverAfter pddDriverAfter);

    /**
     * 批量删除司机售后报表
     * 
     * @param ids 需要删除的司机售后报表主键集合
     * @return 结果
     */
    public int deletePddDriverAfterByIds(Long[] ids);

    /**
     * 删除司机售后报表信息
     * 
     * @param id 司机售后报表主键
     * @return 结果
     */
    public int deletePddDriverAfterById(Long id);
}
