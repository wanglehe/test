package com.army.bo;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class CollectionsTotal {
    @Id
    private String dzid;
    private Double ctmtxsTotal;
    private Double fdjmtxsTotal;
    private Double xslcTotal;
    private Double yhTotal;
    private Date updatetime;

    public String getDzid() {
        return dzid;
    }

    public void setDzid(String dzid) {
        this.dzid = dzid;
    }

    public Double getCtmtxsTotal() {
        return ctmtxsTotal;
    }

    public void setCtmtxsTotal(Double ctmtxsTotal) {
        this.ctmtxsTotal = ctmtxsTotal;
    }

    public Double getFdjmtxsTotal() {
        return fdjmtxsTotal;
    }

    public void setFdjmtxsTotal(Double fdjmtxsTotal) {
        this.fdjmtxsTotal = fdjmtxsTotal;
    }

    public Double getXslcTotal() {
        return xslcTotal;
    }

    public void setXslcTotal(Double xslcTotal) {
        this.xslcTotal = xslcTotal;
    }

    public Double getYhTotal() {
        return yhTotal;
    }

    public void setYhTotal(Double yhTotal) {
        this.yhTotal = yhTotal;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}
