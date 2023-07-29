package com.acm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.acm.mapper.SysAppointmentMapper;
import com.acm.entity.SysAppointment;
import com.acm.service.ISysAppointmentService;

/**
 * 患者预约Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-28
 */
@Service
public class SysAppointmentServiceImpl implements ISysAppointmentService 
{
    @Autowired
    private SysAppointmentMapper sysAppointmentMapper;

    /**
     * 查询患者预约
     * 
     * @param id 患者预约主键
     * @return 患者预约
     */
    @Override
    public SysAppointment selectSysAppointmentById(String id)
    {
        return sysAppointmentMapper.selectSysAppointmentById(id);
    }

    /**
     * 查询患者预约列表
     * 
     * @param sysAppointment 患者预约
     * @return 患者预约
     */
    @Override
    public List<SysAppointment> selectSysAppointmentList(SysAppointment sysAppointment)
    {
        return sysAppointmentMapper.selectSysAppointmentList(sysAppointment);
    }

    /**
     * 新增患者预约
     * 
     * @param sysAppointment 患者预约
     * @return 结果
     */
    @Override
    public int insertSysAppointment(SysAppointment sysAppointment)
    {
        return sysAppointmentMapper.insertSysAppointment(sysAppointment);
    }

    /**
     * 修改患者预约
     * 
     * @param sysAppointment 患者预约
     * @return 结果
     */
    @Override
    public int updateSysAppointment(SysAppointment sysAppointment)
    {
        return sysAppointmentMapper.updateSysAppointment(sysAppointment);
    }

    /**
     * 批量删除患者预约
     * 
     * @param ids 需要删除的患者预约主键
     * @return 结果
     */
    @Override
    public int deleteSysAppointmentByIds(String[] ids)
    {
        return sysAppointmentMapper.deleteSysAppointmentByIds(ids);
    }

    /**
     * 删除患者预约信息
     * 
     * @param id 患者预约主键
     * @return 结果
     */
    @Override
    public int deleteSysAppointmentById(String id)
    {
        return sysAppointmentMapper.deleteSysAppointmentById(id);
    }
}
