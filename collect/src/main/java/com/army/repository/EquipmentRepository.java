package com.army.repository;

import com.army.bo.Equipment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

public interface EquipmentRepository extends JpaRepository<Equipment,String> {
    @Query(value = "select * from equipment WHERE DWDM=?1",
            nativeQuery = true)
    Page<Equipment> findByDWDM(String DWDM, Pageable pageable);
    @Query(value = "select * from equipment", nativeQuery = true)
    Page<Equipment> findNODWDM( Pageable pageable);
}
