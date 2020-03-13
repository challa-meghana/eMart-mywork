package com.project.loginservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.loginservice.dao.entity.SellerSignupEntity;

@Repository
public interface SellerSignupDao extends JpaRepository<SellerSignupEntity, Integer> {

	SellerSignupEntity findBySellerUsernameAndSellerPassword(String sellerUsername, String sellerPassword);

}
