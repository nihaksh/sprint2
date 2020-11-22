package com.cg.go.greatoutdoor.service;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.cg.go.greatoutdoor.dao.IWishlistRepository;
import com.cg.go.greatoutdoor.entity.WishlistItemEntity;
import com.cg.go.greatoutdoor.exception.WishlistException;
import com.cg.go.greatoutdoor.exception.WishlistNotFoundException;

@Transactional
@Service
public class WishlistServiceImpl implements IWishlistService {
	
	@Autowired
	private IWishlistRepository wishlistRepository;

	@Override
	public List<WishlistItemEntity> findAll() {
		List<WishlistItemEntity> list = wishlistRepository.findAll();
		return list;
	}

	// Finding Wishlist based on userId.
	@Override
	public List<WishlistItemEntity> findByUserId(int userId) {
		List<WishlistItemEntity> list = wishlistRepository.findByUserId(userId);
		if (list.size() == 0) {
			throw new WishlistNotFoundException("Wishlist not found for userId=" + userId);
		}
		return list;
	}
    // Delete wishlist by userId
	@Override
	public void deleteByUserId(int userId) {
		Optional<WishlistItemEntity> optional = wishlistRepository.findById(userId);
		if (!optional.isPresent()) {
			throw new WishlistNotFoundException("Product not found for id=" + userId);
		}
		List<WishlistItemEntity> wishlist = findByUserId(userId);
		for (WishlistItemEntity item : wishlist) {
			wishlistRepository.delete(item);
		}

	}

	// Adding WishlistItemEntity if wishlistitem does not exists in the table.
	@Override
	public WishlistItemEntity addWishlistItem(WishlistItemEntity wishlistItem) {
		if (wishlistItem == null) {
			throw new WishlistException("invalid wishlistitem");
		}
		boolean exists = wishlistItem.getWishlistId() != 0
				&& wishlistRepository.existsById(wishlistItem.getWishlistId());
		if (exists) {
			throw new WishlistException("Wishlist already exists for id=" + wishlistItem.getUserId());
		}
		WishlistItemEntity wishlistObject = wishlistRepository.save(wishlistItem);

		return wishlistObject;
	}

	/*
	 * Finding WishlistItem based on userId and productId. First we retrieve the
	 * list based on userId and then find the item/product from the list based on
	 * productId
	 */
	@Override
	public WishlistItemEntity findWishlistItem(String productId, int userId) {
		List<WishlistItemEntity> list = findByUserId(userId);
		for (WishlistItemEntity entity : list) {
			List<String> products = entity.getProductIds();
			if (products != null && products.contains(productId)) {
				return entity;
			}
		}

		throw new WishlistNotFoundException("wishlist not found for user=" + userId + " product=" + productId);

	}
	// Adding product to wishlist based on productId and wishlistId.

	@Override
	public void addProductToWishlist(String prodId, int wishlistID) {
		WishlistItemEntity entity = findWishListById(wishlistID);
		List<String> productIds = entity.getProductIds();
		if (productIds == null) {
			productIds = new ArrayList<>();
			entity.setProductIds(productIds);
		}
		if (!productIds.contains(prodId)) {
			productIds.add(prodId);
			wishlistRepository.save(entity);
		}

	}

	// Finding wishlist by wishlistID
	@Override
	public WishlistItemEntity findWishListById(int wishlistID) {
		Optional<WishlistItemEntity> optional = wishlistRepository.findById(wishlistID);
		if (!optional.isPresent()) {
			throw new WishlistNotFoundException("wishlist not found for id=" + wishlistID);
		}
		return optional.get();
	}

	// Deleting wishlistItem based on productId and userId
	@Override
	public void deleteWishlistItem(String productId, int userId) throws WishlistException {
		WishlistItemEntity entity = findWishlistItem(productId, userId);

		List<String> productIds = entity.getProductIds();
		if (productIds == null || !productIds.contains(productId)) {
			return;
		}
		productIds.remove(productId);
		wishlistRepository.save(entity);
	}

}
