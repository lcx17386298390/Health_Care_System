package com.acm.service;

import java.util.List;
import com.acm.entity.SysAppointment;

/**
 * 患者预约Service接口
 * 
 * @author ruoyi
 * @date 2023-07-28
 */
public interface ISysAppointmentService 
{
    /**
     * 查询患者预约
     * 
     * @param id 患者预约主键
     * @return 患者预约
     */
    public SysAppointment selectSysAppointmentById(String id);

    /**
     * 查询患者预约列表
     * 
     * @param sysAppointment 患者预约
     * @return 患者预约集合
     */
    public List<SysAppointment> selectSysAppointmentList(SysAppointment sysAppointment);

    /**
     * 新增患者预约
     * 
     * @param sysAppointment 患者预约
     * @return 结果
     */
    public int insertSysAppointment(SysAppointment sysAppointment);

    /**
     * 修改患者预约
     * 
     * @param sysAppointment 患者预约
     * @return 结果
     */
    public int updateSysAppointment(SysAppointment sysAppointment);

    /**
     * 批量删除患者预约
     * 
     * @param ids 需要删除的患者预约主键集合
     * @return 结果
     */
    public int deleteSysAppointmentByIds(String[] ids);

    /**
     * 删除患者预约信息
     * 
     * @param id 患者预约主键
     * @return 结果
     */
    public int deleteSysAppointmentById(String id);
}
