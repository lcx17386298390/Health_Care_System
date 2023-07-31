package com.acm.admin.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.acm.annotation.Log;
import com.acm.entity.SysDepartment;
import com.acm.service.ISysDepartmentService;
import com.acm.core.controller.BaseController;
import com.acm.core.domain.AjaxResult;
import com.acm.core.page.TableDataInfo;
import com.acm.enums.BusinessType;
import com.acm.utils.ExcelUtil;
import com.acm.utils.UUIDUtils;
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
 * 科室信息Controller
 * 
 * @author ruoyi
 * @date 2023-07-28
 */
@RestController
@RequestMapping("/department/department")
public class SysDepartmentController extends BaseController
{
    @Autowired
    private ISysDepartmentService sysDepartmentService;

    /**
     * 查询科室信息列表
     */
    @PreAuthorize("@ss.hasPermi('department:department:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysDepartment sysDepartment)
    {
        startPage();
        List<SysDepartment> list = sysDepartmentService.selectSysDepartmentList(sysDepartment);
        return getDataTable(list);
    }

    /**
     * 导出科室信息列表
     */
    @PreAuthorize("@ss.hasPermi('department:department:export')")
    @Log(title = "科室信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysDepartment sysDepartment)
    {
        List<SysDepartment> list = sysDepartmentService.selectSysDepartmentList(sysDepartment);
        ExcelUtil<SysDepartment> util = new ExcelUtil<SysDepartment>(SysDepartment.class);
        util.exportExcel(response, list, "科室信息数据");
    }

    /**
     * 获取科室信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('department:department:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(sysDepartmentService.selectSysDepartmentById(id));
    }

    /**
     * 新增科室信息
     */
    @PreAuthorize("@ss.hasPermi('department:department:add')")
    @Log(title = "科室信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysDepartment sysDepartment)
    {
        sysDepartment.setId(UUID.randomUUID().toString());
        return toAjax(sysDepartmentService.insertSysDepartment(sysDepartment));
    }

    /**
     * 修改科室信息
     */
    @PreAuthorize("@ss.hasPermi('department:department:edit')")
    @Log(title = "科室信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysDepartment sysDepartment)
    {
        return toAjax(sysDepartmentService.updateSysDepartment(sysDepartment));
    }

    /**
     * 删除科室信息
     */
    @PreAuthorize("@ss.hasPermi('department:department:remove')")
    @Log(title = "科室信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(sysDepartmentService.deleteSysDepartmentByIds(ids));
    }
}
