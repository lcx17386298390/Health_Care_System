package com.acm.service.impl;

import java.util.List;

import com.acm.entity.SysPrescription;
import com.acm.mapper.SysPrescriptionMapper;
import com.acm.service.ISysPrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 医生处方Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-28
 */
@Service
public class SysPrescriptionServiceImpl implements ISysPrescriptionService
{
    @Autowired
    private SysPrescriptionMapper sysPrescriptionMapper;

    /**
     * 查询医生处方
     * 
     * @param id 医生处方主键
     * @return 医生处方
     */
    @Override
    public SysPrescription selectSysPrescriptionById(String id)
    {
        return sysPrescriptionMapper.selectSysPrescriptionById(id);
    }

    /**
     * 查询医生处方列表
     * 
     * @param sysPrescription 医生处方
     * @return 医生处方
     */
    @Override
    public List<SysPrescription> selectSysPrescriptionList(SysPrescription sysPrescription)
    {
        return sysPrescriptionMapper.selectSysPrescriptionList(sysPrescription);
    }

    /**
     * 新增医生处方
     * 
     * @param sysPrescription 医生处方
     * @return 结果
     */
    @Override
    public int insertSysPrescription(SysPrescription sysPrescription)
    {
        return sysPrescriptionMapper.insertSysPrescription(sysPrescription);
    }

    /**
     * 修改医生处方
     * 
     * @param sysPrescription 医生处方
     * @return 结果
     */
    @Override
    public int updateSysPrescription(SysPrescription sysPrescription)
    {
        return sysPrescriptionMapper.updateSysPrescription(sysPrescription);
    }

    /**
     * 批量删除医生处方
     * 
     * @param ids 需要删除的医生处方主键
     * @return 结果
     */
    @Override
    public int deleteSysPrescriptionByIds(String[] ids)
    {
        return sysPrescriptionMapper.deleteSysPrescriptionByIds(ids);
    }

    /**
     * 删除医生处方信息
     * 
     * @param id 医生处方主键
     * @return 结果
     */
    @Override
    public int deleteSysPrescriptionById(String id)
    {
        return sysPrescriptionMapper.deleteSysPrescriptionById(id);
    }
}
