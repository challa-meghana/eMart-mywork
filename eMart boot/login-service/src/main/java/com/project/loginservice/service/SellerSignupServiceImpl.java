package com.project.loginservice.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.loginservice.dao.ItemDao;
import com.project.loginservice.dao.SellerSignupDao;
import com.project.loginservice.dao.entity.CategoryEntity;
import com.project.loginservice.dao.entity.ItemEntity;
import com.project.loginservice.dao.entity.SellerSignupEntity;
import com.project.loginservice.dao.entity.SubCategoryEntity;
import com.project.loginservice.model.CategoryPojo;
import com.project.loginservice.model.ItemPojo;
import com.project.loginservice.model.SellerSignupPojo;
import com.project.loginservice.model.SubCategoryPojo;

@Service
public class SellerSignupServiceImpl implements SellerSignupService {
	static Logger LOG = Logger.getLogger(SellerSignupServiceImpl.class.getClass());

	@Autowired
	SellerSignupDao sellerSignupDao;

	@Autowired
	ItemDao itemDao;

	@Override
	public SellerSignupPojo validateSeller(SellerSignupPojo sellerSignupPojo) {
		// LOG.info("Entered validateSeller() ");
		SellerSignupEntity sellerSignupEntity = sellerSignupDao.findBySellerUsernameAndSellerPassword(
				sellerSignupPojo.getSellerUsername(), sellerSignupPojo.getSellerPassword());

		sellerSignupPojo = new SellerSignupPojo(sellerSignupEntity.getSellerId(),
				sellerSignupEntity.getSellerUsername(), sellerSignupEntity.getSellerPassword(),
				sellerSignupEntity.getSellerCompany(), sellerSignupEntity.getSellerBrief(),
				sellerSignupEntity.getSellerGst(), sellerSignupEntity.getSellerAddress(),
				sellerSignupEntity.getSellerEmail(), sellerSignupEntity.getSellerContact(),
				sellerSignupEntity.getSellerWebsite(), null);

		// BasicConfigurator.configure();
		// LOG.info("Exited validateSeller() ");
		return sellerSignupPojo;
	}

	@Override
	public List<ItemPojo> getSellerItems(Integer sellerId) {
		LOG.info("entered getSellerItems()");
		List<ItemPojo> allItemPojo = new ArrayList<ItemPojo>();
		List<ItemEntity> allItemEntity = itemDao.findBySellerSellerId(sellerId);
		Iterator itr = allItemEntity.iterator();
		while (itr.hasNext()) {
			ItemEntity itemEntity = (ItemEntity) itr.next();
			SubCategoryEntity subCategoryEntity = itemEntity.getSubcategory();
			CategoryEntity categoryEntity = subCategoryEntity.getCategory();
			SellerSignupEntity sellerSignupEntity = itemEntity.getSeller();

			CategoryPojo categoryPojo = new CategoryPojo(categoryEntity.getCategoryId(),
					categoryEntity.getCategoryName(), categoryEntity.getCategoryBrief());
			SubCategoryPojo subCategoryPojo = new SubCategoryPojo(subCategoryEntity.getSubCategoryId(),
					subCategoryEntity.getSubCategoryName(), categoryPojo, subCategoryEntity.getSubCategoryBrief(),
					subCategoryEntity.getSubCategoryGst());
			SellerSignupPojo sellerPojo = new SellerSignupPojo(sellerSignupEntity.getSellerId(),
					sellerSignupEntity.getSellerUsername(), sellerSignupEntity.getSellerPassword(),
					sellerSignupEntity.getSellerCompany(), sellerSignupEntity.getSellerBrief(),
					sellerSignupEntity.getSellerGst(), sellerSignupEntity.getSellerAddress(),
					sellerSignupEntity.getSellerEmail(), sellerSignupEntity.getSellerContact(),
					sellerSignupEntity.getSellerWebsite(), null);

			ItemPojo itemPojo = new ItemPojo(itemEntity.getItemId(), itemEntity.getItemName(),
					itemEntity.getItemImage(), itemEntity.getItemPrice(), itemEntity.getItemStock(),
					itemEntity.getItemDescription(), subCategoryPojo, itemEntity.getItemRemarks(), sellerPojo);

			allItemPojo.add(itemPojo);

		}
		BasicConfigurator.configure();
		LOG.info("exited getSellerItems()");
		return allItemPojo;
	}

	@Override
	public SellerSignupPojo addSeller(SellerSignupPojo sellerSignupPojo) {
		LOG.info("entered addSeller()");
		SellerSignupEntity sellerSignupEntity = new SellerSignupEntity(sellerSignupPojo.getSellerId(),
				sellerSignupPojo.getSellerUsername(), sellerSignupPojo.getSellerPassword(),
				sellerSignupPojo.getSellerCompany(), sellerSignupPojo.getSellerBrief(), sellerSignupPojo.getSellerGst(),
				sellerSignupPojo.getSellerAddress(), sellerSignupPojo.getSellerEmail(),
				sellerSignupPojo.getSellerContact(), sellerSignupPojo.getSellerWebsite(), null);

		sellerSignupDao.save(sellerSignupEntity);
		LOG.info("Exited addSeller()");
		return sellerSignupPojo;
	}

	@Override
	public SellerSignupPojo addItem(ItemPojo ItemPojo) {
		return null;
	}

}
