package com.acm.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Department)表实体类
 *
 * @author makejava
 * @since 2023-07-21 15:10:51
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_department")
public class Department  {
    //科室id@TableId
    private String id;

    //科室名
    private String name;
    //医生姓名
    private String dname;
    //医生id
    private String did;
    //科室挂号数量
    private Integer orders;
    //挂号信息id
    private String aid;



}

