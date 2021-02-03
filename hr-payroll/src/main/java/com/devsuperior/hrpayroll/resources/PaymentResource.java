package com.devsuperior.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hrpayroll.entity.Payment;
import com.devsuperior.hrpayroll.service.PaymentService;

@RestController
@RequestMapping(value="/payments")
public class PaymentResource {

	@Autowired
	private PaymentService paymentService;
	
	@GetMapping(value="/{workerId}/days/{days}")
	public ResponseEntity<Payment> listarPagamento(@PathVariable Long workerId, @PathVariable Integer days){
		return ResponseEntity.ok(paymentService.getPayment(workerId, days));
	}
}
