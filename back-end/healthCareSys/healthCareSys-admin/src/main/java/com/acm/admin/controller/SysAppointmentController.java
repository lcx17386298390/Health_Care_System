package com.acm.admin.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.acm.annotation.Log;
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
import com.acm.entity.SysAppointment;
import com.acm.service.ISysAppointmentService;

/**
 * 患者预约Controller
 * 
 * @author ruoyi
 * @date 2023-07-28
 */
@RestController
@RequestMapping("/appointment/appointment")
public class SysAppointmentController extends BaseController
{
    @Autowired
    private ISysAppointmentService sysAppointmentService;

    /**
     * 查询患者预约列表
     */
    @PreAuthorize("@ss.hasPermi('appointment:appointment:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysAppointment sysAppointment)
    {
        startPage();
        List<SysAppointment> list = sysAppointmentService.selectSysAppointmentList(sysAppointment);
        return getDataTable(list);
    }

    /**
     * 导出患者预约列表
     */
    @PreAuthorize("@ss.hasPermi('appointment:appointment:export')")
    @Log(title = "患者预约", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysAppointment sysAppointment)
    {
        List<SysAppointment> list = sysAppointmentService.selectSysAppointmentList(sysAppointment);
        ExcelUtil<SysAppointment> util = new ExcelUtil<SysAppointment>(SysAppointment.class);
        util.exportExcel(response, list, "患者预约数据");
    }

    /**
     * 获取患者预约详细信息
     */
    @PreAuthorize("@ss.hasPermi('appointment:appointment:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(sysAppointmentService.selectSysAppointmentById(id));
    }

    /**
     * 新增患者预约
     */
    @PreAuthorize("@ss.hasPermi('appointment:appointment:add')")
    @Log(title = "患者预约", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysAppointment sysAppointment)
    {
        sysAppointment.setId(UUID.randomUUID().toString());
        return toAjax(sysAppointmentService.insertSysAppointment(sysAppointment));
    }

    /**
     * 修改患者预约
     */
    @PreAuthorize("@ss.hasPermi('appointment:appointment:edit')")
    @Log(title = "患者预约", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysAppointment sysAppointment)
    {
        return toAjax(sysAppointmentService.updateSysAppointment(sysAppointment));
    }

    /**
     * 删除患者预约
     */
    @PreAuthorize("@ss.hasPermi('appointment:appointment:remove')")
    @Log(title = "患者预约", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(sysAppointmentService.deleteSysAppointmentByIds(ids));
    }
}
