package org.shrutika.mvc.dto;

public class CardDetails {

	
	private int cardindex;
	private String transactionStatus;
	private String cardNo;
	private String cardType;
	private String company;
	private String expiratationDate;
	private ShippingAddress billingAddress;
	private String userId;
	public int getCardindex() {
		return cardindex;
	}
	public void setCardindex(int cardindex) {
		this.cardindex = cardindex;
	}
	public String getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getExpiratationDate() {
		return expiratationDate;
	}
	public void setExpiratationDate(String expiratationDate) {
		this.expiratationDate = expiratationDate;
	}
	public ShippingAddress getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(ShippingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
