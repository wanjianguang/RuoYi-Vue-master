package com.ruoyi.analysis.controller;

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

import com.ruoyi.analysis.domain.PddSorterAfter;
import com.ruoyi.analysis.domain.PddSorterAfterReport;
import com.ruoyi.analysis.service.IPddSorterAfterReportService;
import com.ruoyi.analysis.service.IPddSorterAfterService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 分拣员售后报Controller
 * 
 * @author wonderful
 * @date 2021-08-17
 */
@RestController
@RequestMapping("/analysis/sorter")
public class PddSorterAfterController extends BaseController
{
    @Autowired
    private IPddSorterAfterService pddSorterAfterService;
    
    @Autowired
    private IPddSorterAfterReportService pddSorterAfterReportService;

    /**
     * 查询分拣员售后报列表
     */
    @PreAuthorize("@ss.hasPermi('analysis:sorter:list')")
    @GetMapping("/list")
    public TableDataInfo list(PddSorterAfter pddSorterAfter)
    {
        startPage();
        List<PddSorterAfter> list = pddSorterAfterService.selectPddSorterAfterList(pddSorterAfter);
        return getDataTable(list);
    }

    /**
     * 导出分拣员售后报列表
     */
    @PreAuthorize("@ss.hasPermi('analysis:sorter:export')")
    @Log(title = "分拣员售后报表", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PddSorterAfter pddSorterAfter)
    {
    	String pickUpDate = pddSorterAfter.getPickUpDate();
    	if(pickUpDate == null) {
    		return AjaxResult.error("【提货日期】查询条件不能为空!");
    	}
        List<PddSorterAfterReport> list = pddSorterAfterReportService.selectPddSorterAfterReportList(pickUpDate);
        if(list != null && list.size() >0) {
            ExcelUtil<PddSorterAfterReport> util = new ExcelUtil<PddSorterAfterReport>(PddSorterAfterReport.class);
            return util.exportExcel(list, "分拣员售后报数据");
        }else {
        	return AjaxResult.error("【提货日期:"+pickUpDate+"】无导出的数据!");
        }                
    }

    /**
     * 导入表结构（保存）
     */
    @PreAuthorize("@ss.hasPermi('analysis:driver:import')")
    @Log(title = "分拣员售后报表", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importDataSave(MultipartFile file)throws Exception
    {
    	ExcelUtil<PddSorterAfter> util = new ExcelUtil<PddSorterAfter>(PddSorterAfter.class);
    	List<PddSorterAfter> list = util.importExcel(file.getInputStream());

    	int row = 0;
    	for(PddSorterAfter pddSorterAfter:list) {
    		row += pddSorterAfterService.insertPddSorterAfter(pddSorterAfter);
    	}
    	
        return AjaxResult.success("导入成功【"+row+"】条");
    }
    
    /**
     * 获取分拣员售后报详细信息
     */
    @PreAuthorize("@ss.hasPermi('analysis:sorter:query')")
    @GetMapping(value = "/{storeId}")
    public AjaxResult getInfo(@PathVariable("storeId") String storeId)
    {
        return AjaxResult.success(pddSorterAfterService.selectPddSorterAfterByStoreId(storeId));
    }

    /**
     * 新增分拣员售后报
     */
    @PreAuthorize("@ss.hasPermi('analysis:sorter:add')")
    @Log(title = "分拣员售后报", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PddSorterAfter pddSorterAfter)
    {
        return toAjax(pddSorterAfterService.insertPddSorterAfter(pddSorterAfter));
    }

    /**
     * 修改分拣员售后报
     */
    @PreAuthorize("@ss.hasPermi('analysis:sorter:edit')")
    @Log(title = "分拣员售后报", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PddSorterAfter pddSorterAfter)
    {
        return toAjax(pddSorterAfterService.updatePddSorterAfter(pddSorterAfter));
    }

    /**
     * 删除分拣员售后报
     */
    @PreAuthorize("@ss.hasPermi('analysis:sorter:remove')")
    @Log(title = "分拣员售后报", businessType = BusinessType.DELETE)
	@DeleteMapping("/{storeIds}")
    public AjaxResult remove(@PathVariable String[] storeIds)
    {
        return toAjax(pddSorterAfterService.deletePddSorterAfterByStoreIds(storeIds));
    }
}
