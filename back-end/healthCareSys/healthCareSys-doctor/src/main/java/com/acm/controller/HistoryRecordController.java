package com.acm.controller;

import com.acm.entity.HistoryRecord;
import com.acm.service.HistoryRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/doc")
@RequestMapping("/his")
public class HistoryRecordController {
    private final HistoryRecordService historyRecordService;

    @Autowired
    public HistoryRecordController(HistoryRecordService historyRecordService) {
        this.historyRecordService = historyRecordService;
    }

    @GetMapping("/doctor/{doctorName}")
    public ResponseEntity<List<HistoryRecord>> getHistoryRecordsByDoctorName(@PathVariable String doctorName) {
        List<HistoryRecord> historyRecords = historyRecordService.getHistoryRecordsByDoctorName(doctorName);
        return ResponseEntity.ok(historyRecords);
    }
}