package com.cg.go.greatoutdoor.entity;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name="salesReport")
@Entity
/*@NamedQueries({
@NamedQuery(query="select c from SalesReportEntity c where c.productId=:productId and c.quantitySold=:quantitySold and c.totalSale=:totalSale",name="update salesReport"),
@NamedQuery(query="delete from SalesReportEntity s where s.salesReportId=:salesReportId",name="deleting salesreport")})*/
public class SalesReportEntity {
	@GeneratedValue
	@Id
	private long salesReportId;
	private String productId;
	private String productName;
	private Integer quantitySold;
	private double totalSale;
	public SalesReportEntity( String productId, String productName, Integer quantitySold,
			double totalSale) {
		this.productId = productId;
		this.productName = productName;
		this.quantitySold = quantitySold;
		this.totalSale = totalSale;
	}
	public SalesReportEntity() {
		
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
	@Override
	public int hashCode() {
		int hash=Objects.hashCode(salesReportId);
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
		SalesReportEntity other = (SalesReportEntity) obj;
		/*if (salesReportId == null) {
			if (other.salesReportId != null)
				return false;
		} else if (!salesReportId.equals(other.salesReportId))
			return false;*/
		if (salesReportId != other.salesReportId)
			return false;
		return true;
	}
}

