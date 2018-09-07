package com.army.repository;

import com.army.bo.CollectionsTotal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface CollectionsTotalRepository extends JpaRepository<CollectionsTotal,String> {
    @Transactional
    @Modifying
    @Query(value = "update collections_total set ctmtxs_total=?1,fdjmtxs_total=?2,xslc_total=?3,yh_total=?4,updatetime=?5 WHERE dzid=?6",
    nativeQuery = true)
    public int updateCollectionsTotal(Double ctMotoHour,Double fdjMotoHour,Double distance,Double oil,Date updatetime,String dzid
    );
    public CollectionsTotal findByDzidEquals(String dzid);
}
