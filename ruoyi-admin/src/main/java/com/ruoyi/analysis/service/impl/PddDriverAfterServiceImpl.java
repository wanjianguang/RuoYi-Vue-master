package com.ruoyi.analysis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.analysis.domain.PddDriverAfter;
import com.ruoyi.analysis.mapper.PddDriverAfterMapper;
import com.ruoyi.analysis.service.IPddDriverAfterService;

/**
 * 司机售后报表Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-08-14
 */
@Service
public class PddDriverAfterServiceImpl implements IPddDriverAfterService 
{
    @Autowired
    private PddDriverAfterMapper pddDriverAfterMapper;
    
    /**
     * 查询司机售后报表
     * 
     * @param id 司机售后报表主键
     * @return 司机售后报表
     */
    @Override
    public PddDriverAfter selectPddDriverAfterById(Long id)
    {
        return pddDriverAfterMapper.selectPddDriverAfterById(id);
    }

    /**
     * 查询司机售后报表列表
     * 
     * @param pddDriverAfter 司机售后报表
     * @return 司机售后报表
     */
    @Override
    public List<PddDriverAfter> selectPddDriverAfterList(PddDriverAfter pddDriverAfter)
    {
        return pddDriverAfterMapper.selectPddDriverAfterList(pddDriverAfter);
    }

    /**
     * 新增司机售后报表
     * 
     * @param pddDriverAfter 司机售后报表
     * @return 结果
     */
    @Override
    public int insertPddDriverAfter(PddDriverAfter pddDriverAfter)
    {
        return pddDriverAfterMapper.insertPddDriverAfter(pddDriverAfter);
    }

    /**
     * 修改司机售后报表
     * 
     * @param pddDriverAfter 司机售后报表
     * @return 结果
     */
    @Override
    public int updatePddDriverAfter(PddDriverAfter pddDriverAfter)
    {
        return pddDriverAfterMapper.updatePddDriverAfter(pddDriverAfter);
    }

    /**
     * 批量删除司机售后报表
     * 
     * @param ids 需要删除的司机售后报表主键
     * @return 结果
     */
    @Override
    public int deletePddDriverAfterByIds(Long[] ids)
    {
        return pddDriverAfterMapper.deletePddDriverAfterByIds(ids);
    }

    /**
     * 删除司机售后报表信息
     * 
     * @param id 司机售后报表主键
     * @return 结果
     */
    @Override
    public int deletePddDriverAfterById(Long id)
    {
        return pddDriverAfterMapper.deletePddDriverAfterById(id);
    }
}
