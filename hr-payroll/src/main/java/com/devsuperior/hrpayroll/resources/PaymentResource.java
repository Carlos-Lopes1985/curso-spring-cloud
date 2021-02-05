package com.devsuperior.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hrpayroll.entity.Payment;
import com.devsuperior.hrpayroll.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value="/payments")
public class PaymentResource {

	@Autowired
	private PaymentService paymentService;
	
	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping(value="/{workerId}/days/{days}")
	public ResponseEntity<Payment> listarPagamento(@PathVariable Long workerId, @PathVariable Integer days){
		System.out.println(workerId +""+ days);
		return ResponseEntity.ok(paymentService.getPayment(workerId, days));
	}
	
	public ResponseEntity<Payment> getPaymentAlternative( Long workerId, @PathVariable Integer days){
		
		Payment pay = new Payment("Dann", 200., 10);	
		
		return ResponseEntity.ok(pay);
	}
}
