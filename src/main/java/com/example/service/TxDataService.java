package com.example.service;

import com.example.entity.TxData;
import com.example.helper.DataParserUtil;
import com.example.model.ClientInformation;
import com.example.model.ProductInformation;
import com.example.repository.TxDataRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TxDataService {
    private static final Logger logger = LoggerFactory.getLogger(TxDataService.class);

    @Autowired
    private TxDataRepository txDataRepository;


    public List<TxData> findByDate(Date date) {
        return txDataRepository.findByTransactionDate(date);
    }

    public Map<ClientInformation, Map<ProductInformation, List<TxData>>> getClientProductTxDataList(Date date) {
        List<TxData> dataList = findByDate(date);
        logger.info("Found {} records for the date {}", dataList.size(), date);
        return getClientProductTxDataList(dataList);

    }

    public Map<ClientInformation, Map<ProductInformation, List<TxData>>> getClientProductTxDataList(List<TxData> dataList) {
        Map<ClientInformation, Map<ProductInformation, List<TxData>>> result = new HashMap<>();
        Map<ClientInformation, List<TxData>> clientTxData = dataList.stream()
                .collect(Collectors.groupingBy(tx ->
                        new ClientInformation(tx.getClientType(), tx.getClientNumber(),
                                tx.getAccountNumber(), tx.getSubAccountNumber())));

        for (ClientInformation clientInformation : clientTxData.keySet()) {
            List<TxData> txData = clientTxData.get(clientInformation);
            Map<ProductInformation, List<TxData>> clientProductTxData =
                    txData.stream().collect(Collectors.groupingBy(x ->
                            new ProductInformation(x.getProductGroupCode(), x.getExchangeCode(),
                                    x.getSymbol(), x.getExpirationDate())));
            result.put(clientInformation, clientProductTxData);

        }
        return result;
    }

    public void summaryReport(HttpServletResponse response, Map<ClientInformation, Map<ProductInformation, List<TxData>>> result) {
        //set file name and content type

        try {

            CSVPrinter csvPrinter = new CSVPrinter(response.getWriter(),
                    CSVFormat.DEFAULT.withHeader("Client Type", "CLIENT NUMBER", "ACCOUNT NUMBER", "SUBACCOUNT NUMBER",
                            "EXCHANGE CODE", "PRODUCT GROUP CODE", "SYMBOL", "EXPIRATION DATE", "Total_Transaction_Amount"));

            for (ClientInformation ci : result.keySet()) {

                Map<ProductInformation, List<TxData>> clientProductTxData = result.get(ci);
                for (ProductInformation pi : clientProductTxData.keySet()) {
                    List<TxData> txData = clientProductTxData.get(pi);

                    csvPrinter.printRecord(Arrays.asList(ci.getClientType(),
                            ci.getClientNumber(),
                            ci.getAccountNumber(),
                            ci.getSubAccountNumber(),
                            pi.getExchangeCode(),
                            pi.getProductGroupCode(),
                            pi.getSymbol(),
                            DataParserUtil.getDateInString(pi.getExpirationDate(), "yyyyMMdd"),
                            getTotalTransactionAmount(txData)));
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int getTotalTransactionAmount(List<TxData> txData) {
        int totalTxAmt = 0;
        for (TxData txData1 : txData) {
            totalTxAmt += (txData1.getQuantityLong() - txData1.getQuantityShort());
        }
        return totalTxAmt;
    }

    @Transactional
    public void saveAll(List<TxData> txDataList) {
        txDataList.stream().filter(m -> m != null).forEach(m -> txDataRepository.save(m));
    }

}
