package com.acm.admin.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.acm.annotation.Log;
import com.acm.entity.SysPrescription;
import com.acm.service.ISysPrescriptionService;
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
 * 医生处方Controller
 * 
 * @author ruoyi
 * @date 2023-07-28
 */
@RestController
@RequestMapping("/prescription/prescription")
public class SysPrescriptionController extends BaseController
{
    @Autowired
    private ISysPrescriptionService sysPrescriptionService;

    /**
     * 查询医生处方列表
     */
    @PreAuthorize("@ss.hasPermi('prescription:prescription:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysPrescription sysPrescription)
    {
        startPage();
        List<SysPrescription> list = sysPrescriptionService.selectSysPrescriptionList(sysPrescription);
        return getDataTable(list);
    }

    /**
     * 导出医生处方列表
     */
    @PreAuthorize("@ss.hasPermi('prescription:prescription:export')")
    @Log(title = "医生处方", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysPrescription sysPrescription)
    {
        List<SysPrescription> list = sysPrescriptionService.selectSysPrescriptionList(sysPrescription);
        ExcelUtil<SysPrescription> util = new ExcelUtil<SysPrescription>(SysPrescription.class);
        util.exportExcel(response, list, "医生处方数据");
    }

    /**
     * 获取医生处方详细信息
     */
    @PreAuthorize("@ss.hasPermi('prescription:prescription:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(sysPrescriptionService.selectSysPrescriptionById(id));
    }

    /**
     * 新增医生处方
     */
    @PreAuthorize("@ss.hasPermi('prescription:prescription:add')")
    @Log(title = "医生处方", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysPrescription sysPrescription)
    {
        sysPrescription.setId(UUID.randomUUID().toString());
        return toAjax(sysPrescriptionService.insertSysPrescription(sysPrescription));
    }

    /**
     * 修改医生处方
     */
    @PreAuthorize("@ss.hasPermi('prescription:prescription:edit')")
    @Log(title = "医生处方", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysPrescription sysPrescription)
    {
        return toAjax(sysPrescriptionService.updateSysPrescription(sysPrescription));
    }

    /**
     * 删除医生处方
     */
    @PreAuthorize("@ss.hasPermi('prescription:prescription:remove')")
    @Log(title = "医生处方", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(sysPrescriptionService.deleteSysPrescriptionByIds(ids));
    }
}
