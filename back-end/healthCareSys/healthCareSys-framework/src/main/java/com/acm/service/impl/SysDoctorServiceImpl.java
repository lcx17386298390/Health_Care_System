package com.acm.service.impl;

import java.util.List;

import com.acm.entity.SysDoctor;
import com.acm.mapper.SysDoctorMapper;
import com.acm.service.ISysDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 医生信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-28
 */
@Service
public class SysDoctorServiceImpl implements ISysDoctorService
{
    @Autowired
    private SysDoctorMapper sysDoctorMapper;

    /**
     * 查询医生信息
     * 
     * @param id 医生信息主键
     * @return 医生信息
     */
    @Override
    public SysDoctor selectSysDoctorById(String id)
    {
        return sysDoctorMapper.selectSysDoctorById(id);
    }

    /**
     * 查询医生信息列表
     * 
     * @param sysDoctor 医生信息
     * @return 医生信息
     */
    @Override
    public List<SysDoctor> selectSysDoctorList(SysDoctor sysDoctor)
    {
        return sysDoctorMapper.selectSysDoctorList(sysDoctor);
    }

    /**
     * 新增医生信息
     * 
     * @param sysDoctor 医生信息
     * @return 结果
     */
    @Override
    public int insertSysDoctor(SysDoctor sysDoctor)
    {
        return sysDoctorMapper.insertSysDoctor(sysDoctor);
    }

    /**
     * 修改医生信息
     * 
     * @param sysDoctor 医生信息
     * @return 结果
     */
    @Override
    public int updateSysDoctor(SysDoctor sysDoctor)
    {
        return sysDoctorMapper.updateSysDoctor(sysDoctor);
    }

    /**
     * 批量删除医生信息
     * 
     * @param ids 需要删除的医生信息主键
     * @return 结果
     */
    @Override
    public int deleteSysDoctorByIds(String[] ids)
    {
        return sysDoctorMapper.deleteSysDoctorByIds(ids);
    }

    /**
     * 删除医生信息信息
     * 
     * @param id 医生信息主键
     * @return 结果
     */
    @Override
    public int deleteSysDoctorById(String id)
    {
        return sysDoctorMapper.deleteSysDoctorById(id);
    }
}
