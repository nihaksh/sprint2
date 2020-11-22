package com.cg.go.greatoutdoor.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.go.greatoutdoor.entity.SalesReportEntity;

@Repository
public interface ISalesReportRepository extends JpaRepository<SalesReportEntity,Long>{
	//void updateProductReport(String productId,Integer quantity,double totalSale);
	//boolean existsByProductId(String productId);
	SalesReportEntity findByProductId(String productId);
}
