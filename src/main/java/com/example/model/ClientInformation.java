package com.example.model;

import java.util.Objects;

public class ClientInformation {

    private String clientType;
    private int clientNumber;
    private int accountNumber;
    private int subAccountNumber;

    public ClientInformation(String clientType, int clientNumber, int accountNumber, int subAccountNumber) {
        this.clientType = clientType;
        this.clientNumber = clientNumber;
        this.accountNumber = accountNumber;
        this.subAccountNumber = subAccountNumber;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientInformation that = (ClientInformation) o;
        return clientNumber == that.clientNumber &&
                accountNumber == that.accountNumber &&
                subAccountNumber == that.subAccountNumber &&
                clientType.equals(that.clientType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientType, clientNumber, accountNumber, subAccountNumber);
    }

    @Override
    public String toString() {
        return "ClientInformation{" +
                "clientType='" + clientType + '\'' +
                ", clientNumber=" + clientNumber +
                ", accountNumber=" + accountNumber +
                ", subAccountNumber=" + subAccountNumber +
                '}';
    }
}
