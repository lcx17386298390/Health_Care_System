package com.acm.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocDiagnosticsVo {

    //接诊时间
    private Date clinicDate;

    //患者姓名
    private String pname;

    //患者病名
    private String diseaseName;

    //所属科室
    private String department;
}
