package com.acm.service;

import com.acm.entity.SysPrescription;

import java.util.List;

/**
 * prescriptionService接口
 * 
 * @author ruoyi
 * @date 2023-08-01
 */
public interface ISysPrescriptionService 
{
    /**
     * 查询prescription
     * 
     * @param id prescription主键
     * @return prescription
     */
    public SysPrescription selectSysPrescriptionById(String id);

    /**
     * 查询prescription列表
     * 
     * @param sysPrescription prescription
     * @return prescription集合
     */
    public List<SysPrescription> selectSysPrescriptionList(SysPrescription sysPrescription);

    /**
     * 新增prescription
     * 
     * @param sysPrescription prescription
     * @return 结果
     */
    public int insertSysPrescription(SysPrescription sysPrescription);

    /**
     * 修改prescription
     * 
     * @param sysPrescription prescription
     * @return 结果
     */
    public int updateSysPrescription(SysPrescription sysPrescription);

    /**
     * 批量删除prescription
     * 
     * @param ids 需要删除的prescription主键集合
     * @return 结果
     */
    public int deleteSysPrescriptionByIds(String[] ids);

    /**
     * 删除prescription信息
     * 
     * @param id prescription主键
     * @return 结果
     */
    public int deleteSysPrescriptionById(String id);
}
