package com.example.service;

import com.example.entity.TxData;
import com.example.repository.TxDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TxDataService {

    @Autowired
    private TxDataRepository txDataRepository;

    public List<TxData> findAll() {
        return txDataRepository.findAll();
    }

    @Transactional
    public void saveAll(List<TxData> txDataList) {
        txDataList.stream().forEach(m -> txDataRepository.save(m));
    }

}
