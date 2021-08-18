package com.ruoyi.analysis.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ruoyi.analysis.domain.PddDriverAfter;
import com.ruoyi.analysis.domain.PddDriverAfterReport;
import com.ruoyi.analysis.service.IPddDriverAfterReportService;
import com.ruoyi.analysis.service.IPddDriverAfterService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 司机售后报表Controller
 * 
 * @author ruoyi
 * @date 2021-08-14
 */
@RestController
@RequestMapping("/analysis/driver")
public class PddDriverAfterController extends BaseController
{
    @Autowired
    private IPddDriverAfterService pddDriverAfterService;

    @Autowired
    private IPddDriverAfterReportService pddDriverAfterReportService;
    
    /**
     * 查询司机售后报表列表
     */
    @PreAuthorize("@ss.hasPermi('analysis:driver:list')")
    @GetMapping("/list")
    public TableDataInfo list(PddDriverAfter pddDriverAfter)
    {
        startPage();
        List<PddDriverAfter> list = pddDriverAfterService.selectPddDriverAfterList(pddDriverAfter);
        return getDataTable(list);
    }

    /**
     * 导出司机售后报表列表
     */
    @PreAuthorize("@ss.hasPermi('analysis:driver:export')")
    @Log(title = "司机售后报表", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PddDriverAfter pddDriverAfter)
    {
    	String pickUpDate = pddDriverAfter.getPickUpDate();
    	if(pickUpDate == null) {
    		return AjaxResult.error("【提货日期】查询条件不能为空!");
    	}
        List<PddDriverAfterReport> list = pddDriverAfterReportService.selectPddDriverAfterReportList(pickUpDate);
        if(list != null && list.size() >0) {
            ExcelUtil<PddDriverAfterReport> util = new ExcelUtil<PddDriverAfterReport>(PddDriverAfterReport.class);
            return util.exportExcel(list, "司机售后报表数据");
        }else {
        	return AjaxResult.error("【提货日期:"+pickUpDate+"】无导出的数据!");
        }        
    }
    
    /**
     * 导入表结构（保存）
     */
    @PreAuthorize("@ss.hasPermi('analysis:driver:import')")
    @Log(title = "司机售后报表", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importDataSave(MultipartFile file)throws Exception
    {
    	ExcelUtil<PddDriverAfter> util = new ExcelUtil<PddDriverAfter>(PddDriverAfter.class);
    	List<PddDriverAfter> list = util.importExcel(file.getInputStream());

    	int row = 0;
    	for(PddDriverAfter pddDriverAfter:list) {
    		row += pddDriverAfterService.insertPddDriverAfter(pddDriverAfter);
    	}
    	
        return AjaxResult.success("导入成功【"+row+"】条");
    }

    /**
     * 获取司机售后报表详细信息
     */
    @PreAuthorize("@ss.hasPermi('analysis:driver:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(pddDriverAfterService.selectPddDriverAfterById(id));
    }

    /**
     * 新增司机售后报表
     */
    @PreAuthorize("@ss.hasPermi('analysis:driver:add')")
    @Log(title = "司机售后报表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PddDriverAfter pddDriverAfter)
    {
        return toAjax(pddDriverAfterService.insertPddDriverAfter(pddDriverAfter));
    }

    /**
     * 修改司机售后报表
     */
    @PreAuthorize("@ss.hasPermi('analysis:driver:edit')")
    @Log(title = "司机售后报表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PddDriverAfter pddDriverAfter)
    {
        return toAjax(pddDriverAfterService.updatePddDriverAfter(pddDriverAfter));
    }

    /**
     * 删除司机售后报表
     */
    @PreAuthorize("@ss.hasPermi('analysis:driver:remove')")
    @Log(title = "司机售后报表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pddDriverAfterService.deletePddDriverAfterByIds(ids));
    }
}
