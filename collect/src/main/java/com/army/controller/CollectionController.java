package com.army.controller;

import com.army.bo.*;
import com.army.bo.Collections;
import com.army.repository.CollectionsRepository;
import com.army.repository.CollectionsRepository;
import com.army.repository.CollectionsTotalRepository;
import com.army.service.CollectionsService;
import com.army.util.DayUtil;
import com.army.util.SumUtil;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Predicate;

@RestController
public class CollectionController {
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private CollectionsRepository collectionsRepository;
    @Autowired
    private CollectionsService collectionsService;
    @Autowired
    private CollectionsTotalRepository cTRepository;

    @RequestMapping(value = "/saveCollections", method = RequestMethod.GET)
    @ResponseBody
    public boolean saveCollection(Collections collections, Long startTime, Long endTime, Long writeDate) {
        DayUtil dayUtil = new DayUtil();
        Date startDate = dayUtil.timeStamp2Date(startTime);
        Date endDate = dayUtil.timeStamp2Date(endTime);
        Date date = new Date();
        String ip = "unknow ip";
        try {
            InetAddress adrr = InetAddress.getLocalHost();
            ip = adrr.getHostAddress().toString();
            System.out.print(ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        collections.setIp(ip);
        collections.setStartDate(startDate);
        collections.setEndDate(endDate);
        collections.setDate(date);
        Double ctmtxsTotal=0.0;
        Double fdjmtxsTotal=0.0;
        Double xslcTotal=0.0;
        Double yhTotal=0.0;
        Date date1=new Date();
        String dzid=collections.getEquipmentId();
        Optional<CollectionsTotal> optional=cTRepository.findById(dzid);
        if(optional.isPresent()){
            CollectionsTotal cT=optional.get();
            Double o=0.0;
            Double ctmtxs=Optional.ofNullable(cT.getCtmtxsTotal()).orElse(o);
            Double fdjmtxs=Optional.ofNullable(cT.getFdjmtxsTotal()).orElse(o);
            Double xslc=Optional.ofNullable(cT.getXslcTotal()).orElse(o);
            Double yh=Optional.ofNullable(cT.getYhTotal()).orElse(o);
             ctmtxsTotal=ctmtxs+collections.getCtMotoHour();
            fdjmtxsTotal=fdjmtxs+collections.getFdjMotoHour();
            xslcTotal=xslc+collections.getDistance();
             yhTotal=yh+collections.getOil();
            cTRepository.updateCollectionsTotal(ctmtxsTotal,fdjmtxsTotal,xslcTotal,yhTotal,date1,dzid);
        }else{
            CollectionsTotal cT1 = new CollectionsTotal();
            cT1.setCtmtxsTotal(collections.getCtMotoHour());
            cT1.setFdjmtxsTotal(collections.getFdjMotoHour());
            cT1.setXslcTotal(collections.getDistance());
            cT1.setYhTotal(collections.getOil());
            cT1.setUpdatetime(date1);
            cT1.setDzid(dzid);
            cTRepository.save(cT1);
        }
        collectionsRepository.save(collections);
        return true;
    }

    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"DLS_DEAD_LOCAL_STORE", "DLS_DEAD_LOCAL_STORE"})
    @RequestMapping(value = "/findSum")
    public SumResult findSum(String equipmentId) {
        Double o=0.0;
        SumResult sumResult=new SumResult(o,o,o,o);
        CollectionsTotal cT=new CollectionsTotal();
        Optional<CollectionsTotal> optional= cTRepository.findById(equipmentId);
        try {
            cT = optional.get();
            Double ctmtxs=Optional.ofNullable(cT.getCtmtxsTotal()).orElse(o);
            Double fdjmtxs=Optional.ofNullable(cT.getFdjmtxsTotal()).orElse(o);
            Double xslc=Optional.ofNullable(cT.getXslcTotal()).orElse(o);
            Double yh=Optional.ofNullable(cT.getYhTotal()).orElse(o);
            sumResult.setCtMotoHourSum(ctmtxs);
            sumResult.setFdjMotoHourSum(fdjmtxs);
            sumResult.setDistanceSum(xslc);
            sumResult.setOilSum(yh);
        }catch (Exception e){
           return sumResult;
        }
        return sumResult;
    }

    /**
     * 查询最近一周每天数据
     *
     * @param timeStamp
     * @param equipmentId
     * @return
     */
    @RequestMapping(value = "/listMotoHourByWeek")
    public List<MotoHourMonth> listMotoHourByWeek(String timeStamp, String equipmentId) {
        System.out.println("=================================");
        System.out.println("传递的参数timeStamp是：" + timeStamp);
        System.out.println("传递的参数equipmentId是：" + equipmentId);
        System.out.println("=================================");
        List<MotoHourMonth> lists = new ArrayList<MotoHourMonth>();
        Long timeStamp1 = Long.parseLong(timeStamp);
        lists = collectionsService.listMotoHourByWeek(timeStamp1, equipmentId);
        return lists;
    }

    /**
     * 查询最近4周的数据
     *
     * @param timeStamp
     * @param equipmentId
     * @return
     */
    @RequestMapping(value = "/listMotoHourByMonth")
    public List<MotoHourMonth> listMotoHourByMonth(String timeStamp, String equipmentId) {
        System.out.println("=================================");
        System.out.println("传递的参数是：" + timeStamp);
        System.out.println("=================================");
        Long timeStamp1 = Long.parseLong(timeStamp);
        List<MotoHourMonth> lists = new ArrayList<MotoHourMonth>();

        DayUtil dayUtil = new DayUtil();
        for (int i = 0; i < 4; i++) {
            MotoHourMonth motoHourMonth = new MotoHourMonth();
            Double motoHourWeek = 0.0;
            String day = dayUtil.dayAddNum(timeStamp1, i * (-7));
            String day1 = dayUtil.dayAddNum(timeStamp1, (i + 1) * (-7));
            motoHourWeek = collectionsService.listMotoHourByMonth(day1, day, equipmentId);
            String result = dayUtil.date2timeStamp(day);
            motoHourMonth.setDate(result);
            motoHourMonth.setMotoHour(motoHourWeek);
            motoHourMonth.setWeek(SumUtil.whichWeek(i));
            lists.add(motoHourMonth);
        }
        return lists;
    }

    /**
     * 查询历史数据
     *
     * @param equipmentId
     * @return
     */
    @RequestMapping(value = "/listCollectHistory", method = RequestMethod.GET)
    public List<Collections> listCollectHistory(String equipmentId) {
        return collectionsService.listCollectHistory(equipmentId);
    }

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        if (!file.isEmpty()) {
            String saveFileName = file.getOriginalFilename();
            String dir=request.getServletContext().getRealPath("/") ;
            System.out.println("dir:"+dir);
            //File saveFile = new File(request.getSession().getServletContext().getRealPath("/upload/") + saveFileName);
            File saveFile= new File(dir+saveFileName);
            if (!saveFile.getParentFile().exists()) {
                saveFile.getParentFile().mkdirs();
            }
            try {
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
                out.write(file.getBytes());
                out.flush();
                out.close();
                return "上传成功";
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "上传失败,";
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败,";
            }
        } else {
            return "上传失败，因为文件为空.";
        }

    }
}

