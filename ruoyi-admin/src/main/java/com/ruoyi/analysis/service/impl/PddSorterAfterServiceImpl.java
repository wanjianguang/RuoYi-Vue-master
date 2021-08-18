package com.ruoyi.analysis.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.analysis.mapper.PddSorterAfterMapper;
import com.ruoyi.analysis.domain.PddSorterAfter;
import com.ruoyi.analysis.service.IPddSorterAfterService;

/**
 * 分拣员售后报Service业务层处理
 * 
 * @author wonderful
 * @date 2021-08-17
 */
@Service
public class PddSorterAfterServiceImpl implements IPddSorterAfterService 
{
    @Autowired
    private PddSorterAfterMapper pddSorterAfterMapper;

    /**
     * 查询分拣员售后报
     * 
     * @param storeId 分拣员售后报主键
     * @return 分拣员售后报
     */
    @Override
    public PddSorterAfter selectPddSorterAfterByStoreId(String storeId)
    {
        return pddSorterAfterMapper.selectPddSorterAfterByStoreId(storeId);
    }

    /**
     * 查询分拣员售后报列表
     * 
     * @param pddSorterAfter 分拣员售后报
     * @return 分拣员售后报
     */
    @Override
    public List<PddSorterAfter> selectPddSorterAfterList(PddSorterAfter pddSorterAfter)
    {
        return pddSorterAfterMapper.selectPddSorterAfterList(pddSorterAfter);
    }

    /**
     * 新增分拣员售后报
     * 
     * @param pddSorterAfter 分拣员售后报
     * @return 结果
     */
    @Override
    public int insertPddSorterAfter(PddSorterAfter pddSorterAfter)
    {
        return pddSorterAfterMapper.insertPddSorterAfter(pddSorterAfter);
    }

    /**
     * 修改分拣员售后报
     * 
     * @param pddSorterAfter 分拣员售后报
     * @return 结果
     */
    @Override
    public int updatePddSorterAfter(PddSorterAfter pddSorterAfter)
    {
        return pddSorterAfterMapper.updatePddSorterAfter(pddSorterAfter);
    }

    /**
     * 批量删除分拣员售后报
     * 
     * @param storeIds 需要删除的分拣员售后报主键
     * @return 结果
     */
    @Override
    public int deletePddSorterAfterByStoreIds(String[] storeIds)
    {
        return pddSorterAfterMapper.deletePddSorterAfterByStoreIds(storeIds);
    }

    /**
     * 删除分拣员售后报信息
     * 
     * @param storeId 分拣员售后报主键
     * @return 结果
     */
    @Override
    public int deletePddSorterAfterByStoreId(String storeId)
    {
        return pddSorterAfterMapper.deletePddSorterAfterByStoreId(storeId);
    }
}
