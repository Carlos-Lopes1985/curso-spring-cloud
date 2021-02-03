package com.devsuperior.hrpayroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.hrpayroll.entity.Payment;
import com.devsuperior.hrpayroll.entity.Worker;
import com.devsuperior.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
	
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(long workId, int days) {
		
		Worker work = workerFeignClient.findById(workId).getBody();
		
		return new Payment(work.getName(), work.getDailyIncome(),days);
	}
	
	
}
