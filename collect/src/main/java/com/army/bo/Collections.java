package com.army.bo;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import java.util.Date;

@Entity
public class Collections {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String equipmentId;
    private Double ctMotoHour;
    private Double fdjMotoHour;
    private Double ldStartHour;
    private Double jgStartHour;
    private Double hkStartHour;
    private Double dtStartHour;
    private Double flyHour;
    private Double qdNumber;
    private Double pdNumber;
    private Double ddNumber;
    private Double oil;
    private Long userId;
    private String userName;
    private Date date;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startDate;
    private Date endDate;
    private Double distance;
    private String renwu;
    private String ip;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String getRenwu() {
        return renwu;
    }

    public void setRenwu(String renwu) {
        this.renwu = renwu;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Double getCtMotoHour() {
        return ctMotoHour;
    }

    public void setCtMotoHour(Double ctMotoHour) {
        this.ctMotoHour = ctMotoHour;
    }

    public Double getFdjMotoHour() {
        return fdjMotoHour;
    }

    public void setFdjMotoHour(Double fdjMotoHour) {
        this.fdjMotoHour = fdjMotoHour;
    }

    public Double getLdStartHour() {
        return ldStartHour;
    }

    public void setLdStartHour(Double ldStartHour) {
        this.ldStartHour = ldStartHour;
    }

    public Double getJgStartHour() {
        return jgStartHour;
    }

    public void setJgStartHour(Double jgStartHour) {
        this.jgStartHour = jgStartHour;
    }

    public Double getHkStartHour() {
        return hkStartHour;
    }

    public void setHkStartHour(Double hkStartHour) {
        this.hkStartHour = hkStartHour;
    }

    public Double getDtStartHour() {
        return dtStartHour;
    }

    public void setDtStartHour(Double dtStartHour) {
        this.dtStartHour = dtStartHour;
    }

    public Double getFlyHour() {
        return flyHour;
    }

    public void setFlyHour(Double flyHour) {
        this.flyHour = flyHour;
    }

    public Double getQdNumber() {
        return qdNumber;
    }

    public void setQdNumber(Double qdNumber) {
        this.qdNumber = qdNumber;
    }

    public Double getPdNumber() {
        return pdNumber;
    }

    public void setPdNumber(Double pdNumber) {
        this.pdNumber = pdNumber;
    }

    public Double getDdNumber() {
        return ddNumber;
    }

    public void setDdNumber(Double ddNumber) {
        this.ddNumber = ddNumber;
    }

    public Double getOil() {
        return oil;
    }

    public void setOil(Double oil) {
        this.oil = oil;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}

