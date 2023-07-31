package com.acm.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Disease)表实体类
 *
 * @author makejava
 * @since 2023-07-21 15:10:56
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_disease")
public class Disease  {
    @TableId
    private String id;

    //患者id
    private String pid;
    //患者姓名
    private String pname;
    //患者病名
    private String diseaseName;
    //接诊时间
    private Date clinicDate;
    //接诊医生id
    private String did;
    //接诊医生姓名
    private String dname;



}

