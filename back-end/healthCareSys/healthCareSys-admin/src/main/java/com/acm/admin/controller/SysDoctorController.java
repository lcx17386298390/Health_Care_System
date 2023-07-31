package com.acm.admin.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.acm.annotation.Log;
import com.acm.entity.SysDoctor;
import com.acm.service.ISysDoctorService;
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
 * 医生信息Controller
 * 
 * @author ruoyi
 * @date 2023-07-28
 */
@RestController
@RequestMapping("/doctor/doctor")
public class SysDoctorController extends BaseController
{
    @Autowired
    private ISysDoctorService sysDoctorService;

    /**
     * 查询医生信息列表
     */
    @PreAuthorize("@ss.hasPermi('doctor:doctor:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysDoctor sysDoctor)
    {
        startPage();
        List<SysDoctor> list = sysDoctorService.selectSysDoctorList(sysDoctor);
        return getDataTable(list);
    }

    /**
     * 导出医生信息列表
     */
    @PreAuthorize("@ss.hasPermi('doctor:doctor:export')")
    @Log(title = "医生信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysDoctor sysDoctor)
    {
        List<SysDoctor> list = sysDoctorService.selectSysDoctorList(sysDoctor);
        ExcelUtil<SysDoctor> util = new ExcelUtil<SysDoctor>(SysDoctor.class);
        util.exportExcel(response, list, "医生信息数据");
    }

    /**
     * 获取医生信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('doctor:doctor:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(sysDoctorService.selectSysDoctorById(id));
    }

    /**
     * 新增医生信息
     */
    @PreAuthorize("@ss.hasPermi('doctor:doctor:add')")
    @Log(title = "医生信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysDoctor sysDoctor)
    {
        sysDoctor.setId(UUID.randomUUID().toString());
        return toAjax(sysDoctorService.insertSysDoctor(sysDoctor));
    }

    /**
     * 修改医生信息
     */
    @PreAuthorize("@ss.hasPermi('doctor:doctor:edit')")
    @Log(title = "医生信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysDoctor sysDoctor)
    {
        return toAjax(sysDoctorService.updateSysDoctor(sysDoctor));
    }

    /**
     * 删除医生信息
     */
    @PreAuthorize("@ss.hasPermi('doctor:doctor:remove')")
    @Log(title = "医生信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(sysDoctorService.deleteSysDoctorByIds(ids));
    }
}
