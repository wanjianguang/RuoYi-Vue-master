package com.ruoyi.analysis.mapper;

import java.util.List;
import com.ruoyi.analysis.domain.PddDriverAfter;

/**
 * 司机售后报表Mapper接口
 * 
 * @author ruoyi
 * @date 2021-08-14
 */
public interface PddDriverAfterMapper 
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
     * 删除司机售后报表
     * 
     * @param id 司机售后报表主键
     * @return 结果
     */
    public int deletePddDriverAfterById(Long id);

    /**
     * 批量删除司机售后报表
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePddDriverAfterByIds(Long[] ids);
}
