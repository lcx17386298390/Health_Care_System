package com.acm.service;

import com.acm.entity.HistoryRecord;

import java.util.List;

public interface HistoryRecordService {
    List<HistoryRecord> getHistoryRecordsByDoctorName(String doctorName);
}

