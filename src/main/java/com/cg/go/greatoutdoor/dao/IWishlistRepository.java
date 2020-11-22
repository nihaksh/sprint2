
package com.cg.go.greatoutdoor.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.go.greatoutdoor.entity.WishlistItemEntity;




public interface IWishlistRepository extends JpaRepository<WishlistItemEntity,Integer>{


	List<WishlistItemEntity> findByUserId(int userId);

	
}


