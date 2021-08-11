package com.example.oquv_markazi.controller;

import com.example.oquv_markazi.model.Result;
import com.example.oquv_markazi.payload.PaymentRequest;
import com.example.oquv_markazi.servise.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/add")
    public ResponseEntity addPayment(@RequestBody PaymentRequest paymentRequest){
        return paymentService.addPayment(paymentRequest)? ResponseEntity.ok(new Result(true, "to`lov qilindi"))
                : new ResponseEntity(new Result(false, "nimadur xato kiritildi"), HttpStatus.BAD_REQUEST);
    }
}
