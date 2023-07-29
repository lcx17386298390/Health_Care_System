package com.acm.service;

import com.acm.entity.SysDrug;

import java.util.List;

/**
 * 药品信息Service接口
 * 
 * @author ruoyi
 * @date 2023-07-28
 */
public interface ISysDrugService 
{
    /**
     * 查询药品信息
     * 
     * @param id 药品信息主键
     * @return 药品信息
     */
    public SysDrug selectSysDrugById(String id);

    /**
     * 查询药品信息列表
     * 
     * @param sysDrug 药品信息
     * @return 药品信息集合
     */
    public List<SysDrug> selectSysDrugList(SysDrug sysDrug);

    /**
     * 新增药品信息
     * 
     * @param sysDrug 药品信息
     * @return 结果
     */
    public int insertSysDrug(SysDrug sysDrug);

    /**
     * 修改药品信息
     * 
     * @param sysDrug 药品信息
     * @return 结果
     */
    public int updateSysDrug(SysDrug sysDrug);

    /**
     * 批量删除药品信息
     * 
     * @param ids 需要删除的药品信息主键集合
     * @return 结果
     */
    public int deleteSysDrugByIds(String[] ids);

    /**
     * 删除药品信息信息
     * 
     * @param id 药品信息主键
     * @return 结果
     */
    public int deleteSysDrugById(String id);
}
