package com.project.loginservice.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.loginservice.dao.entity.ItemEntity;

@Repository
public interface ItemDao extends JpaRepository<ItemEntity,Integer>{
List<ItemEntity> findBySellerSellerId(int id);
}
