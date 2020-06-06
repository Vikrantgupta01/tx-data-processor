package com.example.helper;

public enum TxDataFields {

    RECORD_CODE(3),
    CLIENT_TYPE(4),
    CLIENT_NUMBER(4),
    ACCOUNT_NUMBER(4),
    SUBACCOUNT_NUMBER(4),

    OPPOSITE_PARTY_CODE(6),
    PRODUCT_GROUP_CODE(2),
    EXCHANGE_CODE(4),
    SYMBOL(6),
    EXPIRATION_DATE(8),
    CURRENCY_CODE(3),
    MOVEMENT_CODE(2),
    BUY_SELL_CODE(1),
    QUANTITY_LONG_SIGN(1),
    QUANTITY_LONG(10),
    QUANTITY_SHORT_SIGN(1),
    QUANTITY_SHORT(10),
    EXCHANGE_FEE(12),
    EXCHANGE_FEE_D_C(1),
    EXCHANGE_FEE_CURR_CD(3),

    CLEARING_FEE(12),
    CLEARING_FEE_D_C(1),
    CLEARING_FEE_CUR_CODE(3),
    COMMISSION(12),
    COMMISSION_D_C(1),
    COMMISSION_CUR_CODE(3),
    TRANSACTION_DATE(8),
    FUTURE_REFERENCE(6),
    TICKET_NUMBER(6),
    EXTERNAL_NUMBER(6),
    TRANSACTION_PRICE(15),
    TRADER_INITIALS(6),
    OPPOSITE_TRADER_ID(7),
    OPEN_CLOSE_CODE(1)  ;

    private int length;

    TxDataFields(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}
