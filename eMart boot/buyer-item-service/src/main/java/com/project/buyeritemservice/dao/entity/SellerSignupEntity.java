package com.project.buyeritemservice.dao.entity;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "seller_signup_table")
public class SellerSignupEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "seller_id")
	int sellerId;

	@Column(name = "seller_username")
	String sellerUsername;

	@Column(name = "seller_password")
	String sellerPassword;

	@Column(name = "seller_company")
	String sellerCompany;

	@Column(name = "seller_brief")
	String sellerBrief;

	@Column(name = "seller_gst")
	int sellerGst;

	@Column(name = "seller_address")
	String sellerAddress;

	@Column(name = "seller_email")
	String sellerEmail;

	@Column(name = "seller_contact")
	long sellerContact;

	@Column(name = "seller_website")
	String sellerWebsite;

	@OneToMany(mappedBy = "seller")
	Set<ItemEntity> allItems;

	public SellerSignupEntity(int sellerId, String sellerUsername, String sellerPassword, String sellerCompany,
			String sellerBrief, int sellerGst, String sellerAddress, String sellerEmail, long sellerContact,
			String sellerWebsite, Set<ItemEntity> allItems) {
		super();
		this.sellerId = sellerId;
		this.sellerUsername = sellerUsername;
		this.sellerPassword = sellerPassword;
		this.sellerCompany = sellerCompany;
		this.sellerBrief = sellerBrief;
		this.sellerGst = sellerGst;
		this.sellerAddress = sellerAddress;
		this.sellerEmail = sellerEmail;
		this.sellerContact = sellerContact;
		this.sellerWebsite = sellerWebsite;
		this.allItems = allItems;
	}

	public SellerSignupEntity() {
		super();
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerUsername() {
		return sellerUsername;
	}

	public void setSellerUsername(String sellerUsername) {
		this.sellerUsername = sellerUsername;
	}

	public String getSellerPassword() {
		return sellerPassword;
	}

	public void setSellerPassword(String sellerPassword) {
		this.sellerPassword = sellerPassword;
	}

	public String getSellerCompany() {
		return sellerCompany;
	}

	public void setSellerCompany(String sellerCompany) {
		this.sellerCompany = sellerCompany;
	}

	public String getSellerBrief() {
		return sellerBrief;
	}

	public void setSellerBrief(String sellerBrief) {
		this.sellerBrief = sellerBrief;
	}

	public int getSellerGst() {
		return sellerGst;
	}

	public void setSellerGst(int sellerGst) {
		this.sellerGst = sellerGst;
	}

	public String getSellerAddress() {
		return sellerAddress;
	}

	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}

	public long getSellerContact() {
		return sellerContact;
	}

	public void setSellerContact(long sellerContact) {
		this.sellerContact = sellerContact;
	}

	public String getSellerWebsite() {
		return sellerWebsite;
	}

	public void setSellerWebsite(String sellerWebsite) {
		this.sellerWebsite = sellerWebsite;
	}

	public Set<ItemEntity> getAllItems() {
		return allItems;
	}

	public void setAllItems(Set<ItemEntity> allItems) {
		this.allItems = allItems;
	}

	@Override
	public String toString() {
		return "SellerSignupEntity [sellerId=" + sellerId + ", sellerUsername=" + sellerUsername + ", sellerPassword="
				+ sellerPassword + ", sellerCompany=" + sellerCompany + ", sellerBrief=" + sellerBrief + ", sellerGst="
				+ sellerGst + ", sellerAddress=" + sellerAddress + ", sellerEmail=" + sellerEmail + ", sellerContact="
				+ sellerContact + ", sellerWebsite=" + sellerWebsite + ", allItems=" + allItems + "]";
	}

}
