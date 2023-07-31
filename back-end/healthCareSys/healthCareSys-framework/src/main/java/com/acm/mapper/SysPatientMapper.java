package com.acm.mapper;

import com.acm.entity.SysPatient;

import java.util.List;

/**
 * 患者信息Mapper接口
 * 
 * @author ruoyi
 * @date 2023-07-28
 */
public interface SysPatientMapper 
{
    /**
     * 查询患者信息
     * 
     * @param id 患者信息主键
     * @return 患者信息
     */
    public SysPatient selectSysPatientById(String id);

    /**
     * 查询患者信息列表
     * 
     * @param sysPatient 患者信息
     * @return 患者信息集合
     */
    public List<SysPatient> selectSysPatientList(SysPatient sysPatient);

    /**
     * 新增患者信息
     * 
     * @param sysPatient 患者信息
     * @return 结果
     */
    public int insertSysPatient(SysPatient sysPatient);

    /**
     * 修改患者信息
     * 
     * @param sysPatient 患者信息
     * @return 结果
     */
    public int updateSysPatient(SysPatient sysPatient);

    /**
     * 删除患者信息
     * 
     * @param id 患者信息主键
     * @return 结果
     */
    public int deleteSysPatientById(String id);

    /**
     * 批量删除患者信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysPatientByIds(String[] ids);
}
