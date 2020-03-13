package com.project.loginservice.service;

import java.util.List;

import com.project.loginservice.model.ItemPojo;
import com.project.loginservice.model.SellerSignupPojo;

public interface SellerSignupService  {
	SellerSignupPojo validateSeller(SellerSignupPojo sellerSignupPojo);
	List<ItemPojo> getSellerItems(Integer sellerId);
	SellerSignupPojo addSeller( SellerSignupPojo sellerSignupPojo);
	SellerSignupPojo addItem( ItemPojo ItemPojo);
}
