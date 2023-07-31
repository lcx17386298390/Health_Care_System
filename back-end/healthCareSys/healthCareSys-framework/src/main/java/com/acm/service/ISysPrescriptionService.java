package com.acm.service;

import com.acm.entity.SysPrescription;

import java.util.List;

/**
 * 医生处方Service接口
 * 
 * @author ruoyi
 * @date 2023-07-28
 */
public interface ISysPrescriptionService 
{
    /**
     * 查询医生处方
     * 
     * @param id 医生处方主键
     * @return 医生处方
     */
    public SysPrescription selectSysPrescriptionById(String id);

    /**
     * 查询医生处方列表
     * 
     * @param sysPrescription 医生处方
     * @return 医生处方集合
     */
    public List<SysPrescription> selectSysPrescriptionList(SysPrescription sysPrescription);

    /**
     * 新增医生处方
     * 
     * @param sysPrescription 医生处方
     * @return 结果
     */
    public int insertSysPrescription(SysPrescription sysPrescription);

    /**
     * 修改医生处方
     * 
     * @param sysPrescription 医生处方
     * @return 结果
     */
    public int updateSysPrescription(SysPrescription sysPrescription);

    /**
     * 批量删除医生处方
     * 
     * @param ids 需要删除的医生处方主键集合
     * @return 结果
     */
    public int deleteSysPrescriptionByIds(String[] ids);

    /**
     * 删除医生处方信息
     * 
     * @param id 医生处方主键
     * @return 结果
     */
    public int deleteSysPrescriptionById(String id);
}
