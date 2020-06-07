package com.example.repository;

import com.example.entity.TxData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TxDataRepository extends JpaRepository<TxData, Integer>{

    List<TxData> findByTransactionDate(Date date);

}
