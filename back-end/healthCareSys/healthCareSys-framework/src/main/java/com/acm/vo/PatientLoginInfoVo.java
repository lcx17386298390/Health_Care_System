package com.acm.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientLoginInfoVo {

    private PatientInfoVo patientInfoVo;

    private String token;

}
