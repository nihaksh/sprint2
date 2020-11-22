package com.cg.go.greatoutdoor.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.go.greatoutdoor.dao.ISalesReportRepository;
import com.cg.go.greatoutdoor.entity.SalesReportEntity;
import com.cg.go.greatoutdoor.exception.SalesReportException;

@Transactional
@Service
public class SalesReportServiceImpl implements ISalesReportService {
	
	@Autowired
    private ISalesReportRepository salesReportRepository;

	@Override
	public List<SalesReportEntity> findAllSalesReport() {
		List<SalesReportEntity> list=salesReportRepository.findAll();
		if(list.isEmpty())
			throw new SalesReportException("Sales Report is empty");
		return list;
		
	}

	@Override
	public SalesReportEntity findSalesReportByProductId(String productId) {
		SalesReportEntity list=salesReportRepository.findByProductId(productId);
		if(list==null) {
			throw new SalesReportException("Sales report not found given productId="+productId);
		}
		return list;
	}

	@Override
	public void updateProductReport(SalesReportEntity salesReportEntity) {
	
		boolean exist=salesReportRepository.existsById(salesReportEntity.getSalesReportId());
		if(!exist) {
			throw new SalesReportException("sales report not found");
		}
		salesReportRepository.save(salesReportEntity);
		
	}

	/*@Override
	public void updateProductReport(SalesReportEntity salesReportEntity) {
	
		SalesReportEntity exist=salesReportRepository.findByProductId(salesReportEntity.getProductId());
		if(exist==null) {
			throw new SalesReportException("sales report not found");
		}
		salesReportRepository.save(salesReportEntity);
		
	}*/
	@Override
	public void deleteAllSalesReport(){
		// TODO Auto-generated method stub
		salesReportRepository.deleteAll();
		
	}

	@Override
	public void deleteSalesReportById(Long salesReportId){
		Optional<SalesReportEntity> optional=salesReportRepository.findById(salesReportId);
		if(!optional.isPresent()){
            throw new SalesReportException("sales report not found for id="+salesReportId);
        }
		salesReportRepository.deleteById(salesReportId);
		
	}

	@Override
	public SalesReportEntity addSalesReport(SalesReportEntity salesReportEntity) {
		/*boolean exists=SalesReportEntity.getProductId()!=null && salesReportRepository.existsById(SalesReportEntity.getProductId());
        if(exists){
            throw new SalesReportException("Product already exists for id="+SalesReportEntity.getProductId());
        }*/
	     System.out.println("inside Add sales");
		SalesReportEntity salesReport=salesReportRepository.save(salesReportEntity);
		return salesReport;
	}

}
