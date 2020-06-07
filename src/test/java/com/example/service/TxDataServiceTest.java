package com.example.service;

import com.example.entity.TxData;
import com.example.model.ClientInformation;
import com.example.model.ProductInformation;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
public class TxDataServiceTest {

    private TxDataService txDataService = new TxDataService();
    private FixedWidthDataParser fixedWidthDataParser = new FixedWidthDataParser();


    @Test
    public void testTxDataTransactionAmountParsing() {
        String data1 = "315CL  432100020001SGXDC FUSGX NK    " +
                "20100910JPY01B 0000000000 " +
                "0000000001000000000060DUSD000000000030DUSD000000000000DJPY201008200012380" +
                "     688032000092500000000             O";

        String data2 = "315CL  432100020001SGXDC FUSGX NK    " +
                "20100910JPY01B 0000000005 " +
                "0000000000000000000060DUSD000000000030DUSD000000000000DJPY201008200012380" +
                "     688032000092500000000             O";

        TxData txData1 = fixedWidthDataParser.getTxData(data1);
        TxData txData2 = fixedWidthDataParser.getTxData(data2);

        List<TxData> txDataList = new ArrayList<>();
        txDataList.add(txData1);
        txDataList.add(txData2);
        Map<ClientInformation, Map<ProductInformation, List<TxData>>> map = txDataService.getClientProductTxDataList(txDataList);

        ClientInformation clientInformation  = map.keySet().stream().findFirst().get();

        Assert.assertEquals("CL",clientInformation.getClientType());
        Assert.assertEquals(4321,clientInformation.getClientNumber());
        Assert.assertEquals(2,clientInformation.getAccountNumber());
        Assert.assertEquals(1,clientInformation.getSubAccountNumber());


        ProductInformation productInformation = map.get(clientInformation).keySet().stream().findFirst().get();

        Assert.assertEquals("SGX",productInformation.getExchangeCode());
        Assert.assertEquals("FU",productInformation.getProductGroupCode());
        Assert.assertEquals("NK",productInformation.getSymbol());
        Assert.assertEquals(4,txDataService.getTotalTransactionAmount(map.get(clientInformation).get(productInformation)));

    }


}
