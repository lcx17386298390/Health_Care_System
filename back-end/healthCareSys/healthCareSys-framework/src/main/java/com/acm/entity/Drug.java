package com.acm.entity;


import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Drug)表实体类
 *
 * @author makejava
 * @since 2023-07-21 15:10:56
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_drug")
public class Drug  {
    //药品id@TableId
    @TableId(type= IdType.AUTO)
    private String id;

    
    private String drugName;
    
    private Double drugPrice;
    
    private Integer drugNums;
    
    private String drugUsage;



}

