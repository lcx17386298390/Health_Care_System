package com.acm.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionVo {
//    病名
    private  String diseaseName;
//    患病简介
    private String diseaseDesc;
//    医生名字
    private String dname;
//    患者名字
    private String pname;
//    药品信息
    private String drugs;

}
