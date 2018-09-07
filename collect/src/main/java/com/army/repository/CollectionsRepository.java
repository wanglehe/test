package com.army.repository;

import com.army.bo.Collections;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface CollectionsRepository extends JpaRepository<Collections,Long>,JpaSpecificationExecutor
{
    @Query(value = "select new map(SUM (oil),SUM (distance),sum (fdjMotoHour),sum (ctMotoHour)) FROM Collections   where equipment_id=?1")
    public Map<String,Double> findSum(String equipmentId);

    @Query(value = "select * FROM collections  WHERE equipment_id =?1",
            nativeQuery = true)
    public Page<Collections> listCollectHistory(String equipmentId, Pageable pageable);
    @Query(value = "SELECT date,SUM(ct_moto_hour)  FROM `collections` WHERE date BETWEEN ?1 AND ?2 AND equipment_id=?3 GROUP BY DAY(date) ORDER BY  DATE  ASC "
    ,nativeQuery = true)
    public List<Object[]> listMotoHourByWeek(String day1,String day2 ,String equipmentId);
    @Query(value = "SELECT  SUM(ct_moto_hour )FROM collections WHERE date BETWEEN ?1 AND ?2 AND equipment_id=?3",nativeQuery = true)
    public Double listMotoHourByMonth(String day1,String day,String equipmentId);
}
