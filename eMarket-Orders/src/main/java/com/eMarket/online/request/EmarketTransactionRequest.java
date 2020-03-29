package com.eMarket.online.request;

import com.eMarket.online.common.EmarketPayment;
import com.eMarket.online.model.EmarketOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmarketTransactionRequest {

	private EmarketOrder emarketOrder;
	private EmarketPayment emarketPayment;
}
