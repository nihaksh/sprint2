package com.cg.go.greatoutdoor.dto.wishlist;

import java.util.List;

public class WishlistItemDetails {
    private int wishlistId;
    private int userId;

    private List<String> productIds;

    public WishlistItemDetails() {
    }

    public WishlistItemDetails(int wishlistId, int userId, List<String> productIds) {
        this.wishlistId = wishlistId;
        this.userId = userId;
        this.productIds = productIds;
    }

    public int getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(int wishlistId) {
        this.wishlistId = wishlistId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<String> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<String> productIds) {
        this.productIds = productIds;
    }
}
