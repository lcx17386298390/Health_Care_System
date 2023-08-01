package com.acm.mapper;

import com.acm.entity.SysPrescription;

import java.util.List;

/**
 * prescriptionMapper接口
 * 
 * @author ruoyi
 * @date 2023-08-01
 */
public interface SysPrescriptionMapper 
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
     * 删除prescription
     * 
     * @param id prescription主键
     * @return 结果
     */
    public int deleteSysPrescriptionById(String id);

    /**
     * 批量删除prescription
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysPrescriptionByIds(String[] ids);
}
