package com.acm.service.impl;

import java.util.List;

import com.acm.entity.SysDrug;
import com.acm.mapper.SysDrugMapper;
import com.acm.service.ISysDrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 药品信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-28
 */
@Service
public class SysDrugServiceImpl implements ISysDrugService
{
    @Autowired
    private SysDrugMapper sysDrugMapper;

    /**
     * 查询药品信息
     * 
     * @param id 药品信息主键
     * @return 药品信息
     */
    @Override
    public SysDrug selectSysDrugById(String id)
    {
        return sysDrugMapper.selectSysDrugById(id);
    }

    /**
     * 查询药品信息列表
     * 
     * @param sysDrug 药品信息
     * @return 药品信息
     */
    @Override
    public List<SysDrug> selectSysDrugList(SysDrug sysDrug)
    {
        return sysDrugMapper.selectSysDrugList(sysDrug);
    }

    /**
     * 新增药品信息
     * 
     * @param sysDrug 药品信息
     * @return 结果
     */
    @Override
    public int insertSysDrug(SysDrug sysDrug)
    {
        return sysDrugMapper.insertSysDrug(sysDrug);
    }

    /**
     * 修改药品信息
     * 
     * @param sysDrug 药品信息
     * @return 结果
     */
    @Override
    public int updateSysDrug(SysDrug sysDrug)
    {
        return sysDrugMapper.updateSysDrug(sysDrug);
    }

    /**
     * 批量删除药品信息
     * 
     * @param ids 需要删除的药品信息主键
     * @return 结果
     */
    @Override
    public int deleteSysDrugByIds(String[] ids)
    {
        return sysDrugMapper.deleteSysDrugByIds(ids);
    }

    /**
     * 删除药品信息信息
     * 
     * @param id 药品信息主键
     * @return 结果
     */
    @Override
    public int deleteSysDrugById(String id)
    {
        return sysDrugMapper.deleteSysDrugById(id);
    }
}
