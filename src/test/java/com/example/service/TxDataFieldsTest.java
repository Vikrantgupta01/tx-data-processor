package com.example.service;

import com.example.helper.TxDataFields;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class TxDataFieldsTest {

    @Test
    public void testLength(){
        int length = 0;
        for (TxDataFields dataFields:
                TxDataFields.values()) {
            length+=dataFields.getLength();

        }

        Assert.assertEquals(176,length);
    }
}


