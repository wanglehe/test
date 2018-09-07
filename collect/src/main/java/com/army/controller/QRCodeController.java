package com.army.controller;

import com.army.bo.Equipment;
import com.army.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QRCodeController {
    @Autowired
    private EquipmentRepository equipmentRepository;
    public static void main(String[] args) throws Exception {
        String text = "http://www.wx-jss.com:8080/#/report_Info?zbid=1120733&zbid=1120733&jldw=3&zbjc=2";
//        QRCodeUtil.encode(text, "11.JPG", "test", true);
    }
//    @RequestMapping(value = "/getQRCode")
//    public void getQRCode(String DWDM){
//        List<Equipment> lists =new ArrayList<Equipment>();
//        lists=equipmentRepository.findAllByDWDM(DWDM);
//        for(Equipment e:lists){
//            String zbid=e.getZBID();
//            String dwdm=e.getDWDM();
//            String zbjc=e.getZBJC();
//            String text="http://www.wx-jss.com:8080/#/report_Info?zbid="+1120733+"&zbid=1120733&dwjm=3&zbjc=2";
//        }
//    }
}
