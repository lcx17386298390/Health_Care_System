package com.acm.mapper;

import java.util.List;
import com.acm.entity.SysAppointment;

/**
 * 患者预约Mapper接口
 * 
 * @author ruoyi
 * @date 2023-07-28
 */
public interface SysAppointmentMapper 
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
     * 删除患者预约
     * 
     * @param id 患者预约主键
     * @return 结果
     */
    public int deleteSysAppointmentById(String id);

    /**
     * 批量删除患者预约
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysAppointmentByIds(String[] ids);
}
