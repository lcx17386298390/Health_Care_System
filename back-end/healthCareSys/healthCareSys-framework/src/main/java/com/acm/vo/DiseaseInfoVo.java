package com.acm.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiseaseInfoVo {
    private String diseaseName;
    //接诊时间
    private Date clinicDate;

    private String dname;

    private Integer id;
}
