package com.citi.ci.cardhub;

import java.io.Serializable;

/**
 * Created by zhang on 2017/12/20.
 */

public class PaymentBean implements Serializable {
    public int imageRes;
    public String bankName;
    public String cardType;
    public String debt;

    public PaymentBean() {
    }

    public PaymentBean(int imageRes, String bankName, String cardType, String debt) {

        this.imageRes = imageRes;
        this.bankName = bankName;
        this.cardType = cardType;
        this.debt = debt;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getDebt() {
        return debt;
    }

    public void setDebt(String debt) {
        this.debt = debt;
    }
}
