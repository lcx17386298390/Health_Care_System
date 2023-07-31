package com.acm.admin.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.acm.annotation.Log;
import com.acm.entity.SysPatient;
import com.acm.service.ISysPatientService;
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
 * 患者信息Controller
 * 
 * @author ruoyi
 * @date 2023-07-28
 */
@RestController
@RequestMapping("/patient/patient")
public class SysPatientController extends BaseController
{
    @Autowired
    private ISysPatientService sysPatientService;

    /**
     * 查询患者信息列表
     */
    @PreAuthorize("@ss.hasPermi('patient:patient:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysPatient sysPatient)
    {
        startPage();
        List<SysPatient> list = sysPatientService.selectSysPatientList(sysPatient);
        return getDataTable(list);
    }

    /**
     * 导出患者信息列表
     */
    @PreAuthorize("@ss.hasPermi('patient:patient:export')")
    @Log(title = "患者信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysPatient sysPatient)
    {
        List<SysPatient> list = sysPatientService.selectSysPatientList(sysPatient);
        ExcelUtil<SysPatient> util = new ExcelUtil<SysPatient>(SysPatient.class);
        util.exportExcel(response, list, "患者信息数据");
    }

    /**
     * 获取患者信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('patient:patient:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(sysPatientService.selectSysPatientById(id));
    }

    /**
     * 新增患者信息
     */
    @PreAuthorize("@ss.hasPermi('patient:patient:add')")
    @Log(title = "患者信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysPatient sysPatient)
    {
        sysPatient.setId(UUID.randomUUID().toString());
        return toAjax(sysPatientService.insertSysPatient(sysPatient));
    }

    /**
     * 修改患者信息
     */
    @PreAuthorize("@ss.hasPermi('patient:patient:edit')")
    @Log(title = "患者信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysPatient sysPatient)
    {
        return toAjax(sysPatientService.updateSysPatient(sysPatient));
    }

    /**
     * 删除患者信息
     */
    @PreAuthorize("@ss.hasPermi('patient:patient:remove')")
    @Log(title = "患者信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(sysPatientService.deleteSysPatientByIds(ids));
    }
}
