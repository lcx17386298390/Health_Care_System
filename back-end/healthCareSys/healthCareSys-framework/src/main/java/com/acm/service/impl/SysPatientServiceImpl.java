package com.acm.service.impl;

import java.util.List;

import com.acm.entity.SysPatient;
import com.acm.mapper.SysPatientMapper;
import com.acm.service.ISysPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 患者信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-28
 */
@Service
public class SysPatientServiceImpl implements ISysPatientService
{
    @Autowired
    private SysPatientMapper sysPatientMapper;

    /**
     * 查询患者信息
     * 
     * @param id 患者信息主键
     * @return 患者信息
     */
    @Override
    public SysPatient selectSysPatientById(String id)
    {
        return sysPatientMapper.selectSysPatientById(id);
    }

    /**
     * 查询患者信息列表
     * 
     * @param sysPatient 患者信息
     * @return 患者信息
     */
    @Override
    public List<SysPatient> selectSysPatientList(SysPatient sysPatient)
    {
        return sysPatientMapper.selectSysPatientList(sysPatient);
    }

    /**
     * 新增患者信息
     * 
     * @param sysPatient 患者信息
     * @return 结果
     */
    @Override
    public int insertSysPatient(SysPatient sysPatient)
    {
        return sysPatientMapper.insertSysPatient(sysPatient);
    }

    /**
     * 修改患者信息
     * 
     * @param sysPatient 患者信息
     * @return 结果
     */
    @Override
    public int updateSysPatient(SysPatient sysPatient)
    {
        return sysPatientMapper.updateSysPatient(sysPatient);
    }

    /**
     * 批量删除患者信息
     * 
     * @param ids 需要删除的患者信息主键
     * @return 结果
     */
    @Override
    public int deleteSysPatientByIds(String[] ids)
    {
        return sysPatientMapper.deleteSysPatientByIds(ids);
    }

    /**
     * 删除患者信息信息
     * 
     * @param id 患者信息主键
     * @return 结果
     */
    @Override
    public int deleteSysPatientById(String id)
    {
        return sysPatientMapper.deleteSysPatientById(id);
    }
}
