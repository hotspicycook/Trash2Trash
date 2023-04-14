package com.trash2trash.trash2trash.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class StripePaymentSource {
    private String cardNumber;
    private String expirationMonth;
    private String expirationYear;
    private String cvv;
    private String name;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String address;

    private StripePaymentSource(Builder builder){
        this.cardNumber =builder.cardNumber;
        this.expirationMonth =builder.expirationMonth;
        this.expirationYear =builder.expirationYear;
        this.cvv =builder.cvv;
        this.name =builder.name;
        this.address =builder.address;

    }
    public static class Builder{
        private String cardNumber;
        private String expirationMonth;
        private String expirationYear;
        private String cvv;
        private String name;
        private String address;

        public Builder cardNumber(String cardNumber){
            this.cardNumber = cardNumber;
            return this;
        }
        public Builder expirationMonth(String expirationMonth){
            this.expirationMonth = expirationMonth;
            return this;
        }
        public Builder expirationYear(String expirationYear){
            this.expirationYear = expirationYear;
            return this;
        }
        public Builder cvv(String cvv){
            this.cvv = cvv;
            return this;
        }
        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder address(String address){
            this.address = address;
            return this;
        }
        public StripePaymentSource build(){
            return new StripePaymentSource(this);
        }


    }

}
