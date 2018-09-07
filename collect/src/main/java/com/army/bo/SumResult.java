package com.army.bo;

public class SumResult {
    private Double oilSum;
    private Double distanceSum;
    private Double fdjMotoHourSum;
    private Double ctMotoHourSum;


    public SumResult(Double oilSum, Double distanceSum, Double fdjMotoHourSum, Double ctMotoHourSum) {
        this.oilSum = oilSum;
        this.distanceSum = distanceSum;
        this.fdjMotoHourSum = fdjMotoHourSum;
        this.ctMotoHourSum = ctMotoHourSum;
    }

    public Double getOilSum() {
        return oilSum;
    }

    public void setOilSum(Double oilSum) {
        this.oilSum = oilSum;
    }

    public Double getDistanceSum() {
        return distanceSum;
    }

    public void setDistanceSum(Double distanceSum) {
        this.distanceSum = distanceSum;
    }

    public Double getFdjMotoHourSum() {
        return fdjMotoHourSum;
    }

    public void setFdjMotoHourSum(Double fdjMotoHourSum) {
        this.fdjMotoHourSum = fdjMotoHourSum;
    }

    public Double getCtMotoHourSum() {
        return ctMotoHourSum;
    }

    public void setCtMotoHourSum(Double ctMotoHourSum) {
        this.ctMotoHourSum = ctMotoHourSum;
    }


}
