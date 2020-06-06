package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRecordCode() {
        return recordCode;
    }

    public void setRecordCode(int recordCode) {
        this.recordCode = recordCode;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public int getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(int clientNumber) {
        this.clientNumber = clientNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getSubAccountNumber() {
        return subAccountNumber;
    }

    public void setSubAccountNumber(int subAccountNumber) {
        this.subAccountNumber = subAccountNumber;
    }

    public String getOppositePartyCode() {
        return oppositePartyCode;
    }

    public void setOppositePartyCode(String oppositePartyCode) {
        this.oppositePartyCode = oppositePartyCode;
    }

    public String getProductGroupCode() {
        return productGroupCode;
    }

    public void setProductGroupCode(String productGroupCode) {
        this.productGroupCode = productGroupCode;
    }

    public String getExchangeCode() {
        return exchangeCode;
    }

    public void setExchangeCode(String exchangeCode) {
        this.exchangeCode = exchangeCode;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public int getMovementCode() {
        return movementCode;
    }

    public void setMovementCode(int movementCode) {
        this.movementCode = movementCode;
    }

    public String getBuySellCode() {
        return buySellCode;
    }

    public void setBuySellCode(String buySellCode) {
        this.buySellCode = buySellCode;
    }

    public String getQuantityLongSign() {
        return quantityLongSign;
    }

    public void setQuantityLongSign(String quantityLongSign) {
        this.quantityLongSign = quantityLongSign;
    }

    public int getQuantityLong() {
        return quantityLong;
    }

    public void setQuantityLong(int quantityLong) {
        this.quantityLong = quantityLong;
    }

    public String getQuantityShortSign() {
        return quantityShortSign;
    }

    public void setQuantityShortSign(String quantityShortSign) {
        this.quantityShortSign = quantityShortSign;
    }

    public int getQuantityShort() {
        return quantityShort;
    }

    public void setQuantityShort(int quantityShort) {
        this.quantityShort = quantityShort;
    }

    public Double getExchangeFee() {
        return exchangeFee;
    }

    public void setExchangeFee(Double exchangeFee) {
        this.exchangeFee = exchangeFee;
    }

    public String getExchangeDC() {
        return exchangeDC;
    }

    public void setExchangeDC(String exchangeDC) {
        this.exchangeDC = exchangeDC;
    }

    public String getExchangeFeeCurrCD() {
        return exchangeFeeCurrCD;
    }

    public void setExchangeFeeCurrCD(String exchangeFeeCurrCD) {
        this.exchangeFeeCurrCD = exchangeFeeCurrCD;
    }

    public Double getClearingFee() {
        return clearingFee;
    }

    public void setClearingFee(Double clearingFee) {
        this.clearingFee = clearingFee;
    }

    public String getClearingDC() {
        return clearingDC;
    }

    public void setClearingDC(String clearingDC) {
        this.clearingDC = clearingDC;
    }

    public String getClearingFeeCurrCD() {
        return clearingFeeCurrCD;
    }

    public void setClearingFeeCurrCD(String clearingFeeCurrCD) {
        this.clearingFeeCurrCD = clearingFeeCurrCD;
    }

    public Double getCommissionFee() {
        return commissionFee;
    }

    public void setCommissionFee(Double commissionFee) {
        this.commissionFee = commissionFee;
    }

    public String getCommissionDC() {
        return commissionDC;
    }

    public void setCommissionDC(String commissionDC) {
        this.commissionDC = commissionDC;
    }

    public String getCommissionFeeCurrCD() {
        return commissionFeeCurrCD;
    }

    public void setCommissionFeeCurrCD(String commissionFeeCurrCD) {
        this.commissionFeeCurrCD = commissionFeeCurrCD;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getFutureReference() {
        return futureReference;
    }

    public void setFutureReference(int futureReference) {
        this.futureReference = futureReference;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public int getExternalNumber() {
        return externalNumber;
    }

    public void setExternalNumber(int externalNumber) {
        this.externalNumber = externalNumber;
    }

    public Double getTransactionPrice() {
        return transactionPrice;
    }

    public void setTransactionPrice(Double transactionPrice) {
        this.transactionPrice = transactionPrice;
    }

    public String getTraderInitials() {
        return traderInitials;
    }

    public void setTraderInitials(String traderInitials) {
        this.traderInitials = traderInitials;
    }

    public String getOppositeTraderId() {
        return oppositeTraderId;
    }

    public void setOppositeTraderId(String oppositeTraderId) {
        this.oppositeTraderId = oppositeTraderId;
    }

    public String getOpenCloseCode() {
        return openCloseCode;
    }

    public void setOpenCloseCode(String openCloseCode) {
        this.openCloseCode = openCloseCode;
    }

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
