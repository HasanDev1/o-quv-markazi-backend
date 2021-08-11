package com.example.oquv_markazi.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentRequest {
    private Double amount;

    private String Comment;

    private String responsible;

    private UUID studentId;

}
