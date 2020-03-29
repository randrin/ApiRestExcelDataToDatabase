package com.eMarket.online.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eMarket.online.request.EmarketTransactionRequest;
import com.eMarket.online.response.EmarketTransactionResponse;
import com.eMarket.online.service.EmarketOrderService;

@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class EmarketOrderController {

	@Autowired
	private EmarketOrderService emarketOrderService;

	@PostMapping("/saveOrder")
	public EmarketTransactionResponse saveOrder(@RequestBody EmarketTransactionRequest request) {
		return emarketOrderService.saveEmarketOrder(request);
	}
}
