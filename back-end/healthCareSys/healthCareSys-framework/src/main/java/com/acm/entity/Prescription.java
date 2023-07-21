package com.acm.entity;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Prescription)表实体类
 *
 * @author makejava
 * @since 2023-07-21 15:10:56
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_prescription")
public class Prescription  {
    //处方id@TableId
    private String id;

    
    private String diseaseId;
    //病名
    private String diseaseName;
    //患病的简介
    private String diseaseDesc;
    //开处方医生id
    private String did;
    //医生姓名
    private String dname;
    //患者id
    private String pid;
    //患者姓名
    private String pname;
    //药瓶信息
    private String drugs;



}

