package com.ruoyi.web.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ruoyi.common.config.RuoYiConfig;

/**
 * 首页
 *
 * @author ruoyi
 */
@Controller
public class SysIndexController
{
    /** 系统基础配置 */
    @Autowired
    private RuoYiConfig ruoyiConfig;

    /**o
     * 访问首页，提示语
     */
    @RequestMapping("/")
    public String index()
    {
    	return "forward:/index.html";
    }
}
