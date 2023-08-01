package com.acm.mapper;

import com.acm.entity.HistoryRecord;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HistoryRecordMapper {
    List<HistoryRecord> getHistoryRecordsByDoctorName(@Param("doctorName") String doctorName);
}
