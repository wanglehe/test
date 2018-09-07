package com.army.serviceImpl;

import com.army.bo.Collections;
import com.army.bo.MotoHourMonth;
import com.army.repository.CollectionsRepository;
import com.army.service.CollectionsService;
import com.army.util.DayUtil;
import com.army.util.SumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class CollectionsServiceImpl implements CollectionsService {
    @Autowired
    private CollectionsRepository collectionsRepository;
    @Override
    public List<MotoHourMonth> listMotoHourByWeek(Long timeStamp, String equipmentId) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String day=formatter.format(timeStamp);
        DayUtil dayUtil= new DayUtil();
        String day1= dayUtil.dayAddNum(timeStamp,-7);
        List<MotoHourMonth> lists = SumUtil.aWeek(timeStamp);
        List<Object[]> objects= collectionsRepository.listMotoHourByWeek(day1,day,equipmentId);
        for(Object[] objects1:objects){
           for(MotoHourMonth motoHourMonth:lists) {
               String date = objects1[0].toString().substring(0, 10);
               if(date.equals(motoHourMonth.getDate())) {
                   Double motoHour = (Double) objects1[1];
                   motoHourMonth.setMotoHour(motoHour);
               }
           }
        }
        return  lists;
    }

    @Override
    public Double listMotoHourByMonth(String day1,String day, String equipmentId) {
        Double motoHourWeek=collectionsRepository.listMotoHourByMonth(day1,day,equipmentId);
        if(motoHourWeek==null) motoHourWeek=0.0;
        return  motoHourWeek;
    }

    @Override
    public List<Collections> listCollectHistory(String equipmentId) {
//        Pageable pageable=new Pageable() {
//        }
//        return collectionsRepository.listCollectHistory(equipmentId, Pageable );
        return  null;
    }


}
