package com.trash2trash.trash2trash.controllers;

import com.trash2trash.trash2trash.dao.PaymentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RestController
public class PaymentController {
    @Autowired
    private PaymentDAO paymentDAO;

    @PostMapping("/makePayment")
    public Map<String,Boolean> makePayment(@RequestParam("amount")double amount,
                                           @RequestParam("card-number")String cardNumber,
                                           @RequestParam("expeiration-date")String expirationDate){
        boolean success = paymentDAO.makePayment(cardNumber,expirationDate.substring(0,2),expirationDate.substring(2),"123",amount);
        Map<String,Boolean> response = new HashMap<>();
        response.put("success",success);
        return response;

    }
}
