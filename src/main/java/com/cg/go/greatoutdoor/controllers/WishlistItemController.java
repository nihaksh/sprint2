package com.cg.go.greatoutdoor.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.go.greatoutdoor.dto.wishlist.AddProductToWishlistItemRequest;
import com.cg.go.greatoutdoor.dto.wishlist.CreateWishlistItemRequest;
import com.cg.go.greatoutdoor.dto.wishlist.WishlistItemDetails;
import com.cg.go.greatoutdoor.entity.WishlistItemEntity;
import com.cg.go.greatoutdoor.service.IWishlistService;
import com.cg.go.greatoutdoor.util.WishlistUtil;



@RequestMapping("/wishlists")
@RestController
public class WishlistItemController {
    private static final Logger Log= LoggerFactory.getLogger(WishlistItemController.class);
    @Autowired
    public IWishlistService wishlistService;
    @Autowired
    private WishlistUtil wishlistutil;

    
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/products/add")
    public WishlistItemDetails add(@RequestBody AddProductToWishlistItemRequest requestData) {
        wishlistService.addProductToWishlist(requestData.getProductId(), requestData.getWishlistId());
       Log.info("*******after adding product");
        WishlistItemEntity wishlistitem = wishlistService.findWishListById(requestData.getWishlistId());
        Log.info("*******after fetching wishlist");
        return wishlistutil.toDetails(wishlistitem);
    }

    @GetMapping("/get/user/{id}")
    public List<WishlistItemDetails> fetchCustomer(@PathVariable("id") int userId) {
        List<WishlistItemEntity> add = wishlistService.findByUserId(userId);
        return wishlistutil.toDetails(add);

    }

    @DeleteMapping("/remove/{id}")
    public String deleteWishlist(@PathVariable("id") int userId) {
        wishlistService.deleteByUserId(userId);
        String response = "removed product with id=" + userId;
        return response;
    }

    @PostMapping("/add")
    public WishlistItemDetails add(@RequestBody CreateWishlistItemRequest requestData) {
        WishlistItemEntity wishlist = new WishlistItemEntity(requestData.getUserId(), null);
        wishlist = wishlistService.addWishlistItem(wishlist);
        return wishlistutil.toDetails(wishlist);
    }

}
