package com.dell.airbnb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dell.airbnb.entities.Payment;
import com.dell.airbnb.repositories.PaymentRepository;

@RestController
public class PaymentController {

    @Autowired
    PaymentRepository repo;

    @GetMapping(value = "/payments")
    public List<Payment> index() {
        return repo.getAll();
    }

    @PostMapping(value = "/payments")
    public Payment create(@RequestBody Payment payment) {
        repo.addPayment(payment);
        return payment;
    }

    @PostMapping(value = "/payments/{id}")
    public String updatePayment(@PathVariable("id") int paymentInt, @RequestBody Payment payment){
        repo.updatePayment(paymentInt,payment);

        return "Successfully Updated.";
    }
}