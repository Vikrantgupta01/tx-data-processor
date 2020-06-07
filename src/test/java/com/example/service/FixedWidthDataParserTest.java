package com.example.service;

import com.example.entity.TxData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
public class FixedWidthDataParserTest {

    private FixedWidthDataParser fixedWidthDataParser = new FixedWidthDataParser();


    @Test
    public void testTxDataParsing(){
        String data = "315CL  432100020001SGXDC FUSGX NK    " +
                "20100910JPY01B 0000000001 " +
                "0000000000000000000060DUSD000000000030DUSD000000000000DJPY201008200012380" +
                "     688032000092500000000             O";

        TxData txData = fixedWidthDataParser.getTxData(data);

        Assert.assertEquals(315, txData.getRecordCode());
        Assert.assertEquals("CL", txData.getClientType());
        Assert.assertEquals(4321, txData.getClientNumber());
        Assert.assertEquals(1, txData.getSubAccountNumber());
        Assert.assertEquals(2, txData.getAccountNumber());
        Assert.assertEquals("NK", txData.getSymbol());
        Assert.assertEquals("JPY", txData.getCurrencyCode());
        Assert.assertEquals("FU", txData.getProductGroupCode());
        Assert.assertEquals(0, txData.getQuantityShort());
        Assert.assertEquals(1, txData.getQuantityLong());
    }
}
