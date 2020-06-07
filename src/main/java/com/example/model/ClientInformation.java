package com.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
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
