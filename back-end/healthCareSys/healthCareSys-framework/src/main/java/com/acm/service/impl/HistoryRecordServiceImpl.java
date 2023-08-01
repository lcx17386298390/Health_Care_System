package com.acm.service.impl;

import com.acm.entity.HistoryRecord;
import com.acm.mapper.HistoryRecordMapper;
import com.acm.service.HistoryRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// com.example.service.impl.HistoryRecordServiceImpl
@Service
public class HistoryRecordServiceImpl implements HistoryRecordService {
    private final HistoryRecordMapper historyRecordMapper;

    @Autowired
    public HistoryRecordServiceImpl(HistoryRecordMapper historyRecordMapper) {
        this.historyRecordMapper = historyRecordMapper;
    }

    @Override
    public List<HistoryRecord> getHistoryRecordsByDoctorName(String doctorName) {
        return historyRecordMapper.getHistoryRecordsByDoctorName(doctorName);
    }
}
