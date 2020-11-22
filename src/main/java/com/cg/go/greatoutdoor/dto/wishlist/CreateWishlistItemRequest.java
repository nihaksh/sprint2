package com.cg.go.greatoutdoor.dto.wishlist;

public class CreateWishlistItemRequest {
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public CreateWishlistItemRequest() {
    }

    public CreateWishlistItemRequest(int userId) {

        this.userId = userId;
    }
}
