package com.army.controller;

import com.army.bo.Collections;
import com.army.bo.Equipment;
import com.army.repository.EquipmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;


@Controller
public class EquipmentController {
    @Autowired
    private EquipmentRepository equipmentRepository;
    @PersistenceContext //注入的是实体管理器,执行持久化操作
     EntityManager entityManager;
    @Autowired
    DataSourceProperties dataSourceProperties;

    @Autowired
    ApplicationContext applicationContext;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public String saveEquipment(Equipment equipment) {
        equipmentRepository.save(equipment);
        String url = "http://59.110.12.152:8080/#/detail?id=";
        return url;
    }
    @RequestMapping(value = "/listEquipment",method = RequestMethod.GET)
    @ResponseBody
    public Page<Equipment> listEquipment(String DWDM, Integer pageNumber, Integer limit) {
        Sort sort = new Sort(Sort.Direction.DESC,"DWDM"); //创建时间降序排序
        Pageable pageable = PageRequest.of(pageNumber,limit,sort);
        if(DWDM==null){
            Page<Equipment> result= equipmentRepository.findNODWDM(pageable);
            return result;
        }
        Page<Equipment> result= equipmentRepository.findByDWDM(DWDM,pageable);
        return  result;
    }
    @RequestMapping(value = "/listAllEquipment",method = RequestMethod.GET)
    @ResponseBody
    public Page<Equipment> listAllEquipment(Integer pageNumber, Integer limit) {
        Sort sort = new Sort(Sort.Direction.DESC,"ZBID"); //创建时间降序排序
        Pageable pageable = PageRequest.of(pageNumber-1,limit,sort);
        Page<Equipment> result= equipmentRepository.findNODWDM(pageable);
        return  result;
    }

    @RequestMapping(value = "/find/{id}")
    @ResponseBody
    public Equipment findByEquipmentID(@PathVariable(value = "id") String id) {
        Optional<Equipment> optional = equipmentRepository.findById(id);
        return optional.get();
    }
    @RequestMapping(value = "/update")
    @ResponseBody
    public void updateEquipment(Equipment equipment) {
       // Optional<Equipment> optional=equipmentRepository.findById(id);
        //Equipment equipment1=optional.get();
        BufferedReader reader;
        Connection conn = null;
        Statement pst = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//
//            conn = DriverManager.getConnection("jdbc:mysql://rm-2ze301ypw843i76oy.mysql.rds.aliyuncs.com:3306/collect?useUnicode=true&characterEncoding=utf8","armdb","1qazXSW@");
//            pst=conn.createStatement();
//            String sql="INSERT INTO `collect`.`user` (`uid`, `username`, `password`) VALUES ('4', 'hlhdidi', '123')";
//            pst.addBatch(sql);
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        equipmentRepository.saveAndFlush(equipment);
    }
    @RequestMapping(value = "/testHtml")
    public String test(){
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        // 查看配置数据源信息
        System.out.println(dataSource);
        System.out.println(dataSource.getClass().getName());
        System.out.println(dataSourceProperties);
        String sql="INSERT INTO user (`uid`, `username`, `password`) VALUES ('4', 'hlhdidi', '123')";
        //执行SQL,输出查到的数据
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
         jdbcTemplate.update(sql);
        return null;
    }
    public static void main(String[] args) throws Exception {
        String str=null;
        Collections c= new Collections();
        c.setIp(str);

    }








    }
