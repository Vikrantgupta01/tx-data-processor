package com.example.model;

import java.util.Date;
import java.util.Objects;

public class ProductInformation {

    private String productGroupCode;
    private String exchangeCode;
    private String symbol;
    private Date expirationDate;

    public ProductInformation(String productGroupCode, String exchangeCode, String symbol, Date expirationDate) {
        this.productGroupCode = productGroupCode;
        this.exchangeCode = exchangeCode;
        this.symbol = symbol;
        this.expirationDate = expirationDate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductInformation that = (ProductInformation) o;
        return productGroupCode.equals(that.productGroupCode) &&
                exchangeCode.equals(that.exchangeCode) &&
                symbol.equals(that.symbol) &&
                expirationDate.equals(that.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productGroupCode, exchangeCode, symbol, expirationDate);
    }

    @Override
    public String toString() {
        return "ProductInformation{" +
                "productGroupCode='" + productGroupCode + '\'' +
                ", exchangeCode='" + exchangeCode + '\'' +
                ", symbol='" + symbol + '\'' +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
