package com.cg.go.greatoutdoor.service;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.go.greatoutdoor.dao.IProductRepository;
import com.cg.go.greatoutdoor.entity.ProductEntity;
import com.cg.go.greatoutdoor.exception.ProductException;

@Transactional
@Service
public class ProductServiceImpl implements IProductService{
	
   
    @Autowired
    private IProductRepository productRepository;

    //Retrieving all records in products table
	@Override
	public List<ProductEntity> findAllProducts() {
		List<ProductEntity> list=productRepository.findAll();
		return list;
	}

	 //Fetching record in products table based on productId
	@Override
	public ProductEntity findByProductId(Integer productId) {
		Optional<ProductEntity> optional=productRepository.findById(productId);
		if(!optional.isPresent()){
            throw new ProductException("Product not found for id="+productId);
        }
		ProductEntity product=optional.get();
		return product;
	}

	//Fetching record(s) in products table based on productCategory
	@Override
	public List<ProductEntity> findByProductCategory(String productCategory) {
		List<ProductEntity> list=productRepository.findByCategory(productCategory);
		return list;
	}

	//Adding product to the table if it is not exists
	@Override
	public ProductEntity addProduct(ProductEntity productEntity) {
		
		boolean exists=productEntity.getProductId()!=null && productRepository.existsById(productEntity.getProductId());
        if(exists){
            throw new ProductException("Product already exists for id="+productEntity.getProductId());
        }
		ProductEntity product=productRepository.save(productEntity);
		return product;
	}

	//Updating the product in the table only if it exists
	@Override
	public ProductEntity updateProduct(ProductEntity productEntity)  {
		boolean exists= productRepository.existsById(productEntity.getProductId());
        if(!exists){
            throw new ProductException("Product does not exists for id="+productEntity.getProductId());
        }
		ProductEntity product=productRepository.save(productEntity);
		return product;
	}


	//Deleting record(s) based on productId
	@Override
	public void deleteByProductId(Integer productId) {
		Optional<ProductEntity> optional=productRepository.findById(productId);
		if(!optional.isPresent()){
            throw new ProductException("Product not found for id="+productId);
        }
		productRepository.deleteById(productId);
		
	}

	//Finding list of records based on productName
	@Override
	public List<ProductEntity> search(String keyword) {
		List<ProductEntity> list=productRepository.findByProductName(keyword);
		return list;
		
	}

	//Finding list of records by filtering based on maximum price
	@Override
	public List<ProductEntity> filter(double maxPrice) {
		List<ProductEntity> list=productRepository.findByRange(maxPrice);
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	/*@Override
	public void updateProductQuantity(Integer quantity, Integer productId) {
		Optional<ProductEntity> optional=daoProduct.findById(productId);
		if(!optional.isPresent()){
            throw new ProductException("Product not found for id="+productId);
        }
		ProductEntity product=optional.get();
		product.setQuantity(quantity);
		
	}*/
}
