package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TxData {

    @Id
    @GeneratedValue
    private int id;

    private int recordCode;
    private String clientType;
    private int clientNumber;
    private int accountNumber;
    private int subAccountNumber;

    private String oppositePartyCode;
    private String productGroupCode;
    private String exchangeCode;
    private String symbol;
    private Date expirationDate;
    private String currencyCode;
    private int movementCode;
    private String buySellCode;
    private String quantityLongSign;
    private int quantityLong;
    private String quantityShortSign;
    private int quantityShort;
    private Double exchangeFee;
    private String exchangeDC;
    private String exchangeFeeCurrCD;

    private Double clearingFee;
    private String clearingDC;
    private String clearingFeeCurrCD;

    private Double commissionFee;
    private String commissionDC;
    private String commissionFeeCurrCD;

    private Date transactionDate;
    private int futureReference;
    private String ticketNumber;
    private int externalNumber;
    private Double transactionPrice;
    private String traderInitials;
    private String oppositeTraderId;
    private String openCloseCode;


    @Override
    public String toString() {
        return "TxData{" +
                "id=" + id +
                ", recordCode='" + recordCode + '\'' +
                ", clientType='" + clientType + '\'' +
                ", clientNumber='" + clientNumber + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", subAccountNumber='" + subAccountNumber + '\'' +
                ", oppositePartyCode='" + oppositePartyCode + '\'' +
                ", productGroupCode='" + productGroupCode + '\'' +
                ", exchangeCode='" + exchangeCode + '\'' +
                ", symbol='" + symbol + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", currencyCode='" + currencyCode + '\'' +
                ", movementCode='" + movementCode + '\'' +
                ", buySellCode='" + buySellCode + '\'' +
                ", quantityLongSign='" + quantityLongSign + '\'' +
                ", quantityLong='" + quantityLong + '\'' +
                ", quantityShortSign='" + quantityShortSign + '\'' +
                ", quantityShort='" + quantityShort + '\'' +
                ", exchangeFee='" + exchangeFee + '\'' +
                ", exchangeDC='" + exchangeDC + '\'' +
                ", exchangeFeeCurrCD='" + exchangeFeeCurrCD + '\'' +
                ", clearingFee='" + clearingFee + '\'' +
                ", clearingDC='" + clearingDC + '\'' +
                ", clearingFeeCurrCD='" + clearingFeeCurrCD + '\'' +
                ", commissionFee='" + commissionFee + '\'' +
                ", commissionDC='" + commissionDC + '\'' +
                ", commissionFeeCurrCD='" + commissionFeeCurrCD + '\'' +
                ", transactionDate='" + transactionDate + '\'' +
                ", futureReference='" + futureReference + '\'' +
                ", ticketNumber='" + ticketNumber + '\'' +
                ", externalNumber='" + externalNumber + '\'' +
                ", transactionPrice='" + transactionPrice + '\'' +
                ", traderInitials='" + traderInitials + '\'' +
                ", oppositeTraderId='" + oppositeTraderId + '\'' +
                ", openCloseCode='" + openCloseCode + '\'' +
                '}';
    }
}
