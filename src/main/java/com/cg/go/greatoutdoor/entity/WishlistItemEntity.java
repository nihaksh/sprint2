package com.cg.go.greatoutdoor.entity;

import javax.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "wishlists")
public class WishlistItemEntity {
    @GeneratedValue
    @Id
    private int wishlistId;
    private int userId;


    @CollectionTable(name = "wishlists_products",joinColumns = @JoinColumn(name = "wishlistid"))
    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "products")
    private List<String> productIds;

    public WishlistItemEntity(int userId, List<String> productId) {
        this.userId = userId;
        this.productIds = productId;
    }

    public WishlistItemEntity() {

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

    @Override
    public int hashCode() {
        int hash = Objects.hashCode(wishlistId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        WishlistItemEntity other = (WishlistItemEntity) obj;
        if (wishlistId != other.wishlistId)
            return false;
        return true;
    }

}
