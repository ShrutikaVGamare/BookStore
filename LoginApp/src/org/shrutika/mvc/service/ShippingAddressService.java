package org.shrutika.mvc.service;

import org.shrutika.mvc.dao.ShippingAddressDao;
import org.shrutika.mvc.dto.ShippingAddress;

public class ShippingAddressService {

	public int addShippingDetails(ShippingAddress address) {
		// TODO Auto-generated method stub
		ShippingAddressDao shippingDao=new ShippingAddressDao();
		int shippingId=shippingDao.addShippingAddress(address);
		return shippingId;
	}

}
