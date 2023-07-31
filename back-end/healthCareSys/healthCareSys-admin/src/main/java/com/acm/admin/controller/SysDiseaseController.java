package com.acm.admin.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.acm.annotation.Log;
import com.acm.entity.SysDisease;
import com.acm.service.ISysDiseaseService;
import com.acm.core.controller.BaseController;
import com.acm.core.domain.AjaxResult;
import com.acm.core.page.TableDataInfo;
import com.acm.enums.BusinessType;
import com.acm.utils.ExcelUtil;
import com.acm.utils.uuid.UUID;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 患者病历Controller
 * 
 * @author ruoyi
 * @date 2023-07-28
 */
@RestController
@RequestMapping("/disease/disease")
public class SysDiseaseController extends BaseController
{
    @Autowired
    private ISysDiseaseService sysDiseaseService;

    /**
     * 查询患者病历列表
     */
    @PreAuthorize("@ss.hasPermi('disease:disease:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysDisease sysDisease)
    {
        startPage();
        List<SysDisease> list = sysDiseaseService.selectSysDiseaseList(sysDisease);
        return getDataTable(list);
    }

    /**
     * 导出患者病历列表
     */
    @PreAuthorize("@ss.hasPermi('disease:disease:export')")
    @Log(title = "患者病历", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysDisease sysDisease)
    {
        List<SysDisease> list = sysDiseaseService.selectSysDiseaseList(sysDisease);
        ExcelUtil<SysDisease> util = new ExcelUtil<SysDisease>(SysDisease.class);
        util.exportExcel(response, list, "患者病历数据");
    }

    /**
     * 获取患者病历详细信息
     */
    @PreAuthorize("@ss.hasPermi('disease:disease:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(sysDiseaseService.selectSysDiseaseById(id));
    }

    /**
     * 新增患者病历
     */
    @PreAuthorize("@ss.hasPermi('disease:disease:add')")
    @Log(title = "患者病历", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysDisease sysDisease)
    {
        sysDisease.setId(UUID.randomUUID().toString());
        return toAjax(sysDiseaseService.insertSysDisease(sysDisease));
    }

    /**
     * 修改患者病历
     */
    @PreAuthorize("@ss.hasPermi('disease:disease:edit')")
    @Log(title = "患者病历", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysDisease sysDisease)
    {
        return toAjax(sysDiseaseService.updateSysDisease(sysDisease));
    }

    /**
     * 删除患者病历
     */
    @PreAuthorize("@ss.hasPermi('disease:disease:remove')")
    @Log(title = "患者病历", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(sysDiseaseService.deleteSysDiseaseByIds(ids));
    }
}
