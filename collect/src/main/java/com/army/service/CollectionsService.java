package com.army.service;

import com.army.bo.Collections;
import com.army.bo.MotoHourMonth;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface CollectionsService {
    public List<MotoHourMonth> listMotoHourByWeek(Long day, String equipmentId);
    public Double listMotoHourByMonth(String day1,String day,String equipmentId);
    public List<Collections> listCollectHistory(String equipmentId);
}
