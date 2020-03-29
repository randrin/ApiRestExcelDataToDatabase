package com.eMarket.online.response;

import com.eMarket.online.model.EmarketOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmarketTransactionResponse {

	private EmarketOrder emarketOrder;
	private String transactionId;
	private double orderTotalPrice;
	private String message;
}
