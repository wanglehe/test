package com.army.util;


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DayUtil {
    public static void main(String[] args){
        String date="http://www.wx-jss.com:8080/#/report_Info?zbid=112200&amp%3Bjldw=178&amp%3Bzbjc=e&amp%3Bzbid=112200";
        String[] strs=date.split("=|&");
        for(String s:strs){
            System.out.println(s);
        }
    }
    public  String dayAddNum(Long date,int num){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         String day=formatter.format(date);
        try {
            Date day1=formatter.parse(day);
            Calendar cal = Calendar.getInstance();
            cal.setTime(day1);
            cal.add(Calendar.DATE,num);
            day1=cal.getTime();
            day=formatter.format(day1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
       return  day;
    }
    public Date timeStamp2Date(Long timeStamp){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String st=formatter.format(timeStamp);
        Date day=new Date();
        try {
             day=formatter.parse(st);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return day;
    }
    public   String date2timeStamp(String date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String timeStamp="1535086201000";
        try {
            Date date1=formatter.parse(date);
            timeStamp=Long.toString(date1.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timeStamp;
    }

}
