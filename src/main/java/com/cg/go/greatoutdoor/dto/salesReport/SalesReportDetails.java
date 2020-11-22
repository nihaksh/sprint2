package com.cg.go.greatoutdoor.dto.salesReport;

import javax.persistence.Id;

public class SalesReportDetails {
	@Id
	private long salesReportId;
	private String productId;
	private String productName;
	private Integer quantitySold;
	private double totalSale;
	public SalesReportDetails (long salesReportId, String productId, String productName, Integer quantitySold,
			double totalSale) {
		this.salesReportId = salesReportId;
		this.productId = productId;
		this.productName = productName;
		this.quantitySold = quantitySold;
		this.totalSale = totalSale;
	}
	public SalesReportDetails() {
		
	}
	public long getSalesReportId() {
		return salesReportId;
	}
	public void setSalesReportId(long salesReportId) {
		this.salesReportId = salesReportId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getQuantitySold() {
		return quantitySold;
	}
	public void setQuantitySold(Integer quantitySold) {
		this.quantitySold = quantitySold;
	}
	public double getTotalSale() {
		return totalSale;
	}
	public void setTotalSale(double totalSale) {
		this.totalSale = totalSale;
	}
	
}

