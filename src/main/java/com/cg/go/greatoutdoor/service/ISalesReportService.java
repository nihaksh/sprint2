package com.cg.go.greatoutdoor.service;

import java.util.List;

import com.cg.go.greatoutdoor.entity.SalesReportEntity;
import com.cg.go.greatoutdoor.exception.SalesReportException;

public interface ISalesReportService {

	List<SalesReportEntity> findAllSalesReport();

	SalesReportEntity findSalesReportByProductId(String productId);

	void updateProductReport(SalesReportEntity salesReportEntity);

	void deleteAllSalesReport() throws SalesReportException;

	void deleteSalesReportById(Long salesReportId) throws SalesReportException;

	SalesReportEntity addSalesReport(SalesReportEntity salesReport);

}
