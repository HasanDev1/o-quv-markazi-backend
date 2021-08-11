package com.example.oquv_markazi.servise.impl;

import com.example.oquv_markazi.entity.Payment;
import com.example.oquv_markazi.payload.PaymentRequest;
import com.example.oquv_markazi.repository.PaymentRepository;
import com.example.oquv_markazi.repository.StudentRepository;
import com.example.oquv_markazi.servise.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final StudentRepository studentRepository;
    private final PaymentRepository paymentRepository;

    @Override
    public boolean addPayment(PaymentRequest paymentRequest) {
        Payment payment = new Payment();
        payment.setAmount(paymentRequest.getAmount());
        payment.setComment(paymentRequest.getComment());
        payment.setResponsible(paymentRequest.getResponsible());
        payment.setStudents(studentRepository.getById(paymentRequest.getStudentId()));
        paymentRepository.save(payment);
        return true;
    }
}
