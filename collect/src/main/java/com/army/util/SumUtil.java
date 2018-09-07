package com.army.util;

import com.army.bo.MotoHourMonth;

import java.util.ArrayList;
import java.util.List;

public class SumUtil {
    public static final String firstWeek="本周";
    public static final String secondWeek="上一周";
    public static final String thirdWeek="上两周";
    public static final String fourWeek="上三周";
    public static String  whichWeek(int i){
        switch (i){
            case 0:
                return firstWeek;
            case 1:
                return secondWeek;
            case 2:
                return thirdWeek;
            case 3:
                return fourWeek;
        }
        return "没有本周";
    }
    public static List<MotoHourMonth> aWeek(Long day){
        List<MotoHourMonth> lists= new ArrayList<MotoHourMonth>();
        DayUtil dayUtil= new DayUtil();
        for(int i=6;i>=0;i--){
            MotoHourMonth motoHourMonth= new MotoHourMonth();
            String date=dayUtil.dayAddNum(day,-i).substring(0,10);
            motoHourMonth.setDate(date);
            motoHourMonth.setMotoHour(0.0);
            lists.add(motoHourMonth);
        }
        return lists;
    }



}
