package com.cg.go.greatoutdoor.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.go.greatoutdoor.dto.salesReport.CreateSalesReportRequest;
import com.cg.go.greatoutdoor.dto.salesReport.SalesReportDetails;
import com.cg.go.greatoutdoor.dto.salesReport.UpdateSalesReportRequest;
import com.cg.go.greatoutdoor.entity.SalesReportEntity;
import com.cg.go.greatoutdoor.exception.SalesReportException;
import com.cg.go.greatoutdoor.service.ISalesReportService;

@RequestMapping("/salesReport")
@RestController
public class SalesReportController {
	
	 
	@Autowired
	public ISalesReportService service;
	
	/**
     * effective url will be http://localhost:6588/salesReport/add
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public SalesReportDetails add(@RequestBody CreateSalesReportRequest requestData) {
        SalesReportEntity salesReport = new SalesReportEntity(requestData.getProductId(),requestData.getProductName(),requestData.getQuantitySold(),requestData.getTotalSale());
        salesReport = service.addSalesReport(salesReport);
        SalesReportDetails details = toDetails(salesReport);
        return details;
    }

	@PutMapping("/update/{id}")
    public /*SalesReportDetails*/ String update(@PathVariable("id") Long salesReportId,@RequestBody UpdateSalesReportRequest requestData) {
		SalesReportEntity salesReportEntity = new SalesReportEntity(requestData.getProductId(),requestData.getProductName(),requestData.getQuantitySold(),requestData.getTotalSale());
		salesReportEntity.setSalesReportId(requestData.getSalesReportId());
		
		
		//salesReportEntity.setProductId(requestData.getProductId());
		service.updateProductReport(salesReportEntity);
		return "updated successfuuly";
        
    }

    
    
    @GetMapping("/allSalesReports")
    public List<SalesReportDetails> findAll() {
        List<SalesReportEntity> salesReports = service.findAllSalesReport();
        List<SalesReportDetails> details = toDetails(salesReports);
        return details;
    }
    
    @GetMapping("/by/productid/{id}")
    public SalesReportDetails findByproductId(@PathVariable("id") String productId) {
        SalesReportEntity product = service.findSalesReportByProductId(productId);
        SalesReportDetails details = toDetails(product);
        return details;
    }
    @DeleteMapping("/delete")
    public String deleteallSalesReport() throws SalesReportException {
         service.deleteAllSalesReport();
        return "all saless reports dleted";
        
    }
   
    
    @DeleteMapping("/remove/{id}")
    public String deleteSalesReport(@PathVariable("id") Long salesReportId) throws SalesReportException {
         service.deleteSalesReportById(salesReportId);
        String response = "removed product with id=" + salesReportId;
        return response;
    }
    
    
	private SalesReportDetails toDetails(SalesReportEntity salesReportEntity) {
		
		SalesReportDetails salesReportDetails = new SalesReportDetails(salesReportEntity.getSalesReportId(),salesReportEntity.getProductId(),salesReportEntity.getProductName(),salesReportEntity.getQuantitySold(),salesReportEntity.getTotalSale());
		return salesReportDetails;
	}
    

    private List<SalesReportDetails > toDetails(List<SalesReportEntity> salesReports) {
    	//Log.info("Inside toDetails products:"+products);
    	List<SalesReportDetails > salesReportDetails  = new ArrayList<>();
        for (SalesReportEntity salesReport : salesReports) {
        	SalesReportDetails  details = toDetails(salesReport);
        	salesReportDetails.add(details);
        }
    	return salesReportDetails;
	}

}
