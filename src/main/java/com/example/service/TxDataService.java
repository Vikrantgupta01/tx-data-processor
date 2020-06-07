package com.example.service;

import com.example.entity.TxData;
import com.example.helper.DataParserUtil;
import com.example.model.ClientInformation;
import com.example.model.ProductInformation;
import com.example.repository.TxDataRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TxDataService {

    @Autowired
    private TxDataRepository txDataRepository;


    public List<TxData> findByDate(Date date) {
        return txDataRepository.findByTransactionDate(date);
    }

    public Map<ClientInformation, Map<ProductInformation, List<TxData>>> getClientProductTxDataList(Date date) {
        List<TxData> dataList = findByDate(date);
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
        String filename = "report.csv";

        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");

        try {

            CSVPrinter csvPrinter = new CSVPrinter(response.getWriter(),
                    CSVFormat.DEFAULT.withHeader("Client Type", "CLIENT NUMBER", "ACCOUNT NUMBER", "SUBACCOUNT NUMBER",
                            "EXCHANGE CODE", "PRODUCT GROUP CODE", "SYMBOL", "EXPIRATION DATE", "Total_Transaction_Amount"));

            for (ClientInformation ci : result.keySet()) {

                Map<ProductInformation, List<TxData>> clientProductTxData = result.get(ci);
                for (ProductInformation pi : clientProductTxData.keySet()) {
                    List<TxData> txData = clientProductTxData.get(pi);
                    int Total_Transaction_Amount = 0;
                    for (TxData txData1 : txData) {
                        Total_Transaction_Amount += (txData1.getQuantityLong() - txData1.getQuantityShort());
                    }
                    csvPrinter.printRecord(Arrays.asList(ci.getClientType(),
                            ci.getClientNumber(),
                            ci.getAccountNumber(),
                            ci.getSubAccountNumber(),
                            pi.getExchangeCode(),
                            pi.getProductGroupCode(),
                            pi.getSymbol(),
                            DataParserUtil.getDateInString(pi.getExpirationDate(), "yyyyMMdd"),
                            Total_Transaction_Amount));
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Transactional
    public void saveAll(List<TxData> txDataList) {
        txDataList.stream().forEach(m -> txDataRepository.save(m));
    }

}
