package com.trash2trash.trash2trash.dao;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Token;
import com.stripe.param.ChargeCreateParams;
import com.stripe.param.TokenCreateParams;
import com.trash2trash.trash2trash.model.Payment;

import com.trash2trash.trash2trash.service.StripePaymentSource;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDAO extends Payment{
    @Autowired
    private EntityManager entityManager;
//    @Autowired
//    PaymentRepository paymentRepository;


    public void save(Payment payment){

        entityManager.persist(payment);
    }
    public List<Payment> findAll(){

        return entityManager.createQuery("FROM payment ",Payment.class).getResultList();
    }
@Transactional
    public boolean makePayment(String cardNumber, String expMonth, String expYear, String cvv, double amount) {
        StripePaymentSource source = new StripePaymentSource.Builder()
                .name(cardNumber)
                .expirationMonth(expMonth)
                .expirationYear(expYear)
                .cvv(cvv)
                .build();
        Stripe.apiKey = "sk_test_51MggOsEmnA1fj8aGlgg8QxXi3Kpa4ZBZr2eyLQDLHeBuB3TvTqhdCjIM8D6uZK6ZTsGZJs6yi9YZqRv8X6BanAAI00bHHaojAK";

        try {
            Token token = Token.create(TokenCreateParams.builder()
                    .setCard(TokenCreateParams.Card.builder()
                            .setNumber(cardNumber)
                            .setExpMonth(expMonth)
                            .setExpYear(expYear)
                            .setCvc(cvv)
                            .build())
                    .build());

            ChargeCreateParams params = ChargeCreateParams.builder()
                    .setAmount((long) amount*100)
                    .setCurrency("usd")
                    .setSource(token.getId())
                    .build();

            Charge charge = Charge.create(params);
            System.out.println(charge);
            Payment payment = new Payment();
            payment.setAmount(amount);
            payment.setCardNumber(cardNumber);
            payment.setExpMonth(expMonth);
            payment.setExpYear(expMonth);
            payment.setCvv(cvv);
           // paymentRepository.save(payment);
            return true;
        }catch(StripeException e ){
            System.out.println(e.getMessage());
            return false;
        }

    }

    //I want this to take payment and store it in the database
}
