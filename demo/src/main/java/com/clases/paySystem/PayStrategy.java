package com.clases.paySystem;

public interface PayStrategy {
    boolean pay(int paymentAmount);
    void collectPaymentDetails();
}