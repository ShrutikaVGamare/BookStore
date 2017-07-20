package org.shrutika.mvc.service;

import java.util.List;

import org.shrutika.mvc.dao.PromotionDao;
import org.shrutika.mvc.dto.Promotions;

public class PromotionService {

	public String addPromotion(Promotions promotions) {
		// TODO Auto-generated method stub
		PromotionDao promDao=new PromotionDao();
		String result=promDao.addPromotion(promotions);
		return result;
	}

	public List<Promotions> getAllPromotions() {
		// TODO Auto-generated method stub
		PromotionDao promotionDao=new PromotionDao();
		List<Promotions> promList=promotionDao.getAllPromotions();
		return promList;
	}

	public List<Promotions> deletePromo(String[] selectedPromos) {
		PromotionDao promoObj=new PromotionDao();
		List<Promotions> result=promoObj.deletePromo(selectedPromos);
		return result;
	}

}
