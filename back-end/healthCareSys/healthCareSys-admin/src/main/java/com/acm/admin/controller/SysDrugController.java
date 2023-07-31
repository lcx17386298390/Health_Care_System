package com.acm.admin.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.acm.annotation.Log;
import com.acm.entity.SysDrug;
import com.acm.service.ISysDrugService;
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
 * 药品信息Controller
 * 
 * @author ruoyi
 * @date 2023-07-28
 */
@RestController
@RequestMapping("/drug/drug")
public class SysDrugController extends BaseController
{
    @Autowired
    private ISysDrugService sysDrugService;

    /**
     * 查询药品信息列表
     */
    @PreAuthorize("@ss.hasPermi('drug:drug:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysDrug sysDrug)
    {
        startPage();
        List<SysDrug> list = sysDrugService.selectSysDrugList(sysDrug);
        return getDataTable(list);
    }

    /**
     * 导出药品信息列表
     */
    @PreAuthorize("@ss.hasPermi('drug:drug:export')")
    @Log(title = "药品信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysDrug sysDrug)
    {
        List<SysDrug> list = sysDrugService.selectSysDrugList(sysDrug);
        ExcelUtil<SysDrug> util = new ExcelUtil<SysDrug>(SysDrug.class);
        util.exportExcel(response, list, "药品信息数据");
    }

    /**
     * 获取药品信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('drug:drug:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(sysDrugService.selectSysDrugById(id));
    }

    /**
     * 新增药品信息
     */
    @PreAuthorize("@ss.hasPermi('drug:drug:add')")
    @Log(title = "药品信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysDrug sysDrug)
    {
        sysDrug.setId(UUID.randomUUID().toString());
        return toAjax(sysDrugService.insertSysDrug(sysDrug));
    }

    /**
     * 修改药品信息
     */
    @PreAuthorize("@ss.hasPermi('drug:drug:edit')")
    @Log(title = "药品信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysDrug sysDrug)
    {
        return toAjax(sysDrugService.updateSysDrug(sysDrug));
    }

    /**
     * 删除药品信息
     */
    @PreAuthorize("@ss.hasPermi('drug:drug:remove')")
    @Log(title = "药品信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(sysDrugService.deleteSysDrugByIds(ids));
    }
}
