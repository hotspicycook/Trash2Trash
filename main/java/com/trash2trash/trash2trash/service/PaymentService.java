package com.trash2trash.trash2trash.service;

import com.trash2trash.trash2trash.dao.PaymentDAO;
import com.trash2trash.trash2trash.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentDAO paymentDAO;

    public void save(Payment payment){
        paymentDAO.save(payment);
    }

    public List<Payment> findAllPayments(){
        return paymentDAO.findAll();
    }
}
