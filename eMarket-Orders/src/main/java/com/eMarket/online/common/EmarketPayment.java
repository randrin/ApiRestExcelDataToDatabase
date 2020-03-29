package com.eMarket.online.common;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmarketPayment implements Serializable {

	private static final long serialVersionUID = -4402188211314360105L;

	private int idPayment;
	private String paymentStatus;
	private String transactionId;
	private int orderId;
	private double orderTotalPrice;
	
}
