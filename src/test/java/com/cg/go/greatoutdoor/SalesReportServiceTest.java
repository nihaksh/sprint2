package com.cg.go.greatoutdoor;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.cg.go.greatoutdoor.dao.ISalesReportRepository;
import com.cg.go.greatoutdoor.entity.SalesReportEntity;
import com.cg.go.greatoutdoor.exception.SalesReportException;
import com.cg.go.greatoutdoor.service.SalesReportServiceImpl;

@ExtendWith(MockitoExtension.class)
public class SalesReportServiceTest {
	
	@Mock
	ISalesReportRepository salesReportRepository;

	@InjectMocks
	SalesReportServiceImpl service;
	
	/**
	 * Scenario: Test if salesReport is added  or not
	 * 
	 */
	@Test
	public void addSalesReportTest() throws Exception
	{
		SalesReportEntity sales = mock(SalesReportEntity.class);
		service.addSalesReport(sales);
		verify(salesReportRepository).save(sales);
	}
	
	
	/**
	 * Scenario: View salesReport by ProductId
	 * condition: salesReport exists for given ProductId
	 * @throws SalesReportException
	 */	
	@Test
	public void findSalesreportBasedOnProductIdTest() throws SalesReportException
	{
		String productId = String.valueOf(1L);
		SalesReportEntity sales = mock(SalesReportEntity.class);
		//Optional<SalesReportEntity> optional = Optional.of(sales);
		when(salesReportRepository.findByProductId(productId)).thenReturn(sales);
		SalesReportEntity actual = service.findSalesReportByProductId(productId);
		verify(salesReportRepository).findByProductId(productId);
		Assertions.assertEquals(sales,actual);
	}
	/*
	 * test for finding all SalesReport
	 */
	@Test
	public void findallSalesreportsTest() throws SalesReportException
	{
		List<SalesReportEntity> list = new ArrayList<>();
		SalesReportEntity s1 = mock(SalesReportEntity.class);
		SalesReportEntity s2 = mock(SalesReportEntity.class);
		SalesReportEntity s3 = mock(SalesReportEntity.class);
		list.add(s1);
		list.add(s2);
		list.add(s3);
		when(salesReportRepository.findAll()).thenReturn(list);
		List<SalesReportEntity> actual = service.findAllSalesReport();
		Assertions.assertEquals(list.size(), actual.size());
		verify(salesReportRepository).findAll();

	
	}
	
	
	
	
	
}
