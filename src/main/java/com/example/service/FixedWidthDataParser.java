package com.example.service;

import com.example.entity.TxData;
import com.example.helper.DataParserUtil;
import com.example.helper.TxDataFields;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class FixedWidthDataParser {


    public List<TxData> getParsedData(MultipartFile file) {
        List<TxData> txData = new ArrayList<>();
        try {
            BufferedReader fileReader =
                    new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"));
            fileReader.lines().forEach(m -> txData.add(getTxData(m)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return txData;
    }

    public TxData getTxData(String rawData) {
        TxData txData = new TxData();
        Map<TxDataFields, String> dataMap = getDataMap(rawData);
        txData.setRecordCode(DataParserUtil.getInteger(dataMap.get(TxDataFields.RECORD_CODE)));
        txData.setClientType(DataParserUtil.getString(dataMap.get(TxDataFields.CLIENT_TYPE)));
        txData.setClientNumber(DataParserUtil.getInteger(dataMap.get(TxDataFields.CLIENT_NUMBER)));
        txData.setAccountNumber(DataParserUtil.getInteger(dataMap.get(TxDataFields.ACCOUNT_NUMBER)));
        txData.setSubAccountNumber(DataParserUtil.getInteger(dataMap.get(TxDataFields.SUBACCOUNT_NUMBER)));
        txData.setOppositePartyCode(DataParserUtil.getString(dataMap.get(TxDataFields.OPPOSITE_PARTY_CODE)));
        txData.setProductGroupCode(DataParserUtil.getString(dataMap.get(TxDataFields.PRODUCT_GROUP_CODE)));
        txData.setExchangeCode(DataParserUtil.getString(dataMap.get(TxDataFields.EXCHANGE_CODE)));
        txData.setSymbol(DataParserUtil.getString(dataMap.get(TxDataFields.SYMBOL)));
        txData.setExpirationDate(DataParserUtil.getDate(dataMap.get(TxDataFields.EXPIRATION_DATE),"yyyyMMdd"));
        txData.setCurrencyCode(DataParserUtil.getString(dataMap.get(TxDataFields.CURRENCY_CODE)));
        txData.setMovementCode(DataParserUtil.getInteger(dataMap.get(TxDataFields.MOVEMENT_CODE)));
        txData.setBuySellCode(dataMap.get(TxDataFields.BUY_SELL_CODE));
        txData.setQuantityLongSign(dataMap.get(TxDataFields.QUANTITY_LONG_SIGN));
        txData.setQuantityLong(DataParserUtil.getInteger(dataMap.get(TxDataFields.QUANTITY_LONG)));
        txData.setQuantityShort(DataParserUtil.getInteger(dataMap.get(TxDataFields.QUANTITY_SHORT)));
        txData.setQuantityShortSign(dataMap.get(TxDataFields.QUANTITY_SHORT_SIGN));

        txData.setExchangeFee(DataParserUtil.getDouble(dataMap.get(TxDataFields.EXCHANGE_FEE),2));
        txData.setExchangeDC(dataMap.get(TxDataFields.EXCHANGE_FEE_D_C));
        txData.setExchangeFeeCurrCD(dataMap.get(TxDataFields.EXCHANGE_FEE_CURR_CD));

        txData.setCommissionFee(DataParserUtil.getDouble(dataMap.get(TxDataFields.COMMISSION),2));
        txData.setCommissionDC(dataMap.get(TxDataFields.COMMISSION_D_C));
        txData.setCommissionFeeCurrCD(dataMap.get(TxDataFields.COMMISSION_CUR_CODE));

        txData.setClearingFee(DataParserUtil.getDouble(dataMap.get(TxDataFields.CLEARING_FEE),2));
        txData.setClearingDC(dataMap.get(TxDataFields.CLEARING_FEE_D_C));
        txData.setClearingFeeCurrCD(dataMap.get(TxDataFields.CLEARING_FEE_CUR_CODE));

        txData.setTransactionDate(DataParserUtil.getDate(dataMap.get(TxDataFields.TRANSACTION_DATE),"yyyyMMdd"));
        txData.setFutureReference(DataParserUtil.getInteger(dataMap.get(TxDataFields.FUTURE_REFERENCE)));
        txData.setTicketNumber(dataMap.get(TxDataFields.TICKET_NUMBER));
        txData.setExternalNumber(DataParserUtil.getInteger(dataMap.get(TxDataFields.EXTERNAL_NUMBER)));
        txData.setTransactionPrice(DataParserUtil.getDouble(dataMap.get(TxDataFields.TRANSACTION_PRICE),7));
        txData.setTraderInitials(dataMap.get(TxDataFields.TRADER_INITIALS).trim());
        txData.setOppositeTraderId(dataMap.get(TxDataFields.OPPOSITE_TRADER_ID).trim());
        txData.setOpenCloseCode(dataMap.get(TxDataFields.OPEN_CLOSE_CODE));
        return txData;
    }

    public Map<TxDataFields, String> getDataMap(String rawData) {
        Map<TxDataFields, String> dataMap = new HashMap<>();
        int pointer = 0;
        for (TxDataFields dataFields : TxDataFields.values()) {
            dataMap.put(dataFields, rawData.substring(pointer, pointer+dataFields.getLength()));
            pointer += dataFields.getLength();
        }
        return dataMap;
    }


}