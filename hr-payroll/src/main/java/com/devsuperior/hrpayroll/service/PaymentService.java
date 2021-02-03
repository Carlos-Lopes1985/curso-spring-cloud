package com.devsuperior.hrpayroll.service;

import org.springframework.stereotype.Service;

import com.devsuperior.hrpayroll.entity.Payment;

@Service
public class PaymentService {

	public Payment getPayment(long workId, int days) {
		return new Payment("Carlos", 200.,days);
	}
}
