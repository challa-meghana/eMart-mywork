package com.project.loginservice.controller;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.loginservice.model.ItemPojo;
import com.project.loginservice.model.SellerSignupPojo;
import com.project.loginservice.service.SellerSignupService;

@RestController
@RequestMapping("eMart")
@CrossOrigin

public class SellerSignupController {
	static Logger LOG = Logger.getLogger(SellerSignupController.class.getClass());
	@Autowired
	SellerSignupService sellerSignupService;

	@PostMapping("seller")
	SellerSignupPojo addSeller(@RequestBody SellerSignupPojo sellerSignupPojo) {
		BasicConfigurator.configure();
		LOG.info("entered controller addSeller");

		LOG.info("exited controller addSeller");
		return sellerSignupService.addSeller(sellerSignupPojo);
	}

	@GetMapping("validateSeller")
	SellerSignupPojo validateSeller(@RequestHeader("Authorization") String data) {
		LOG.info("Entered end point \'eMart/validateSeller \' ");
		String token[] = data.split(":");
		SellerSignupPojo sellerSignupPojo = new SellerSignupPojo();
		sellerSignupPojo.setSellerUsername(token[0]);
		sellerSignupPojo.setSellerPassword(token[1]);
		LOG.info("Exited end point \'eMart/validateSeller \' ");
		return sellerSignupService.validateSeller(sellerSignupPojo);
	}

	@GetMapping("seller/{sellerId}")
	List<ItemPojo> getSellerItems(@PathVariable("sellerId") Integer sellerId) {
		LOG.info("Entered end point \'eMart/seller/{sellerId} \' ");
		LOG.info("Exited end point \'eMart/seller/{sellerId} \' ");
		return sellerSignupService.getSellerItems(sellerId);
	}
}
