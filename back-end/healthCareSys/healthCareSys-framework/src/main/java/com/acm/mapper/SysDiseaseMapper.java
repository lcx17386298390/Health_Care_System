package com.acm.mapper;

import com.acm.entity.SysDisease;

import java.util.List;

/**
 * 患者病历Mapper接口
 * 
 * @author ruoyi
 * @date 2023-07-28
 */
public interface SysDiseaseMapper 
{
    /**
     * 查询患者病历
     * 
     * @param id 患者病历主键
     * @return 患者病历
     */
    public SysDisease selectSysDiseaseById(String id);

    /**
     * 查询患者病历列表
     * 
     * @param sysDisease 患者病历
     * @return 患者病历集合
     */
    public List<SysDisease> selectSysDiseaseList(SysDisease sysDisease);

    /**
     * 新增患者病历
     * 
     * @param sysDisease 患者病历
     * @return 结果
     */
    public int insertSysDisease(SysDisease sysDisease);

    /**
     * 修改患者病历
     * 
     * @param sysDisease 患者病历
     * @return 结果
     */
    public int updateSysDisease(SysDisease sysDisease);

    /**
     * 删除患者病历
     * 
     * @param id 患者病历主键
     * @return 结果
     */
    public int deleteSysDiseaseById(String id);

    /**
     * 批量删除患者病历
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysDiseaseByIds(String[] ids);
}
