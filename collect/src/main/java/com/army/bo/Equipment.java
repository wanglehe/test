package com.army.bo;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Equipment {
    @Id
    private String ZBID;//装备id
    private String ZBJC;//装备简称
    private String DWDM;//单位代码
    private String SSLD;//所属连队
    private String zbbh;//战斗编号
    private String photo;//二维码

    public String getZBID() {
        return ZBID;
    }

    public void setZBID(String ZBID) {
        this.ZBID = ZBID;
    }

    public String getZBJC() {
        return ZBJC;
    }

    public void setZBJC(String ZBJC) {
        this.ZBJC = ZBJC;
    }

    public String getDWDM() {
        return DWDM;
    }

    public void setDWDM(String DWDM) {
        this.DWDM = DWDM;
    }

    public String getSSLD() {
        return SSLD;
    }

    public void setSSLD(String SSLD) {
        this.SSLD = SSLD;
    }

    public String getZDBH() {
        return zbbh;
    }

    public void setZDBH(String ZDBH) {
        this.zbbh = ZDBH;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
