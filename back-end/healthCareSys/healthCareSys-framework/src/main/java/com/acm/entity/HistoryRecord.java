package com.acm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryRecord {
    private String doctorName;
    private String diseaseName;
    private String diseaseDesc;
    private String drugs;
    private String patientId;
    private String patientName;
    private Date clinicDate;
    private String appointmentDepartment;

    // Add getters and setters for the properties
}
