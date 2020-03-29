package com.eMarket.online.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eMarket.online.common.EmarketPayment;
import com.eMarket.online.model.EmarketOrder;
import com.eMarket.online.repository.EmarketOrderRepository;
import com.eMarket.online.request.EmarketTransactionRequest;
import com.eMarket.online.response.EmarketTransactionResponse;
import com.eMarket.online.utils.EmarketOrderConstants;

@Service
@Transactional
public class EmarketOrderService {

	@Autowired
	private EmarketOrderRepository emarketOrderRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public EmarketTransactionResponse saveEmarketOrder(EmarketTransactionRequest request) {
		
		String message = "";
		
		EmarketOrder order = request.getEmarketOrder();
		EmarketPayment payment = request.getEmarketPayment();
		
		payment.setOrderTotalPrice(order.getOrderPrice());
		payment.setOrderId(order.getId());
		
		EmarketPayment emarketPaymentResponse = restTemplate.postForObject(EmarketOrderConstants.URL_POST_PAYMENT, payment, EmarketPayment.class);
		
		message = emarketPaymentResponse.getPaymentStatus().equals("success") ? EmarketOrderConstants.SUCCESS_PAYMENT : EmarketOrderConstants.FAILED_PAYMENT;
		emarketOrderRepository.save(order);
		
		return new EmarketTransactionResponse(order, emarketPaymentResponse.getTransactionId(), order.getOrderPrice(), message);
	}
	
}
