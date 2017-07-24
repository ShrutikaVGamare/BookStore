package org.shrutika.mvc.service;

import org.shrutika.mvc.dao.TransactionDao;
import org.shrutika.mvc.dto.CardDetails;

public class TransactionService {

	public String performTransaction(CardDetails details, String shippingId) {
		// TODO Auto-generated method stub
		
		return new TransactionDao().perfromTransaction(details,shippingId);
	}

}
