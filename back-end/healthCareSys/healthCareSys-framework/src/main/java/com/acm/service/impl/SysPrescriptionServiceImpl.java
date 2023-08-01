package com.acm.service.impl;

import java.util.List;

import com.acm.entity.SysPrescription;
import com.acm.mapper.SysPrescriptionMapper;
import com.acm.service.ISysPrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * prescriptionService业务层处理
 * 
 * @author ruoyi
 * @date 2023-08-01
 */
@Service
public class SysPrescriptionServiceImpl implements ISysPrescriptionService
{
    @Autowired
    private SysPrescriptionMapper sysPrescriptionMapper;

    /**
     * 查询prescription
     * 
     * @param id prescription主键
     * @return prescription
     */
    @Override
    public SysPrescription selectSysPrescriptionById(String id)
    {
        return sysPrescriptionMapper.selectSysPrescriptionById(id);
    }

    /**
     * 查询prescription列表
     * 
     * @param sysPrescription prescription
     * @return prescription
     */
    @Override
    public List<SysPrescription> selectSysPrescriptionList(SysPrescription sysPrescription)
    {
        return sysPrescriptionMapper.selectSysPrescriptionList(sysPrescription);
    }

    /**
     * 新增prescription
     * 
     * @param sysPrescription prescription
     * @return 结果
     */
    @Override
    public int insertSysPrescription(SysPrescription sysPrescription)
    {
        return sysPrescriptionMapper.insertSysPrescription(sysPrescription);
    }

    /**
     * 修改prescription
     * 
     * @param sysPrescription prescription
     * @return 结果
     */
    @Override
    public int updateSysPrescription(SysPrescription sysPrescription)
    {
        return sysPrescriptionMapper.updateSysPrescription(sysPrescription);
    }

    /**
     * 批量删除prescription
     * 
     * @param ids 需要删除的prescription主键
     * @return 结果
     */
    @Override
    public int deleteSysPrescriptionByIds(String[] ids)
    {
        return sysPrescriptionMapper.deleteSysPrescriptionByIds(ids);
    }

    /**
     * 删除prescription信息
     * 
     * @param id prescription主键
     * @return 结果
     */
    @Override
    public int deleteSysPrescriptionById(String id)
    {
        return sysPrescriptionMapper.deleteSysPrescriptionById(id);
    }
}
