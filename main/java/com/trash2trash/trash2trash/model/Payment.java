package com.trash2trash.trash2trash.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Table(name="payments")
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    public Payment(long id, BigDecimal amount, Data paymentDate) {
        this.id = id;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    //public BigDecimal getAmount() {
//        return amount;
//    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setExpMonth(String expMonth) {
        this.expMonth = expMonth;
    }

    public void setExpYear(String expYear) {
        this.expYear = expYear;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public void setAmount(double amount) {
        this.amount = BigDecimal.valueOf(amount);
    }

    public Data getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Data paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="amount")
    private BigDecimal amount;

    @Column(name = "payment_date")
    private Data paymentDate;


    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "exp_month")
    private String expMonth;

    @Column(name = "exp_year")
    private String expYear;

    @Column(name = "cvv")
    private String cvv;

}
