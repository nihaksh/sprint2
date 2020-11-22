package com.cg.go.greatoutdoor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.go.greatoutdoor.entity.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer>{

}
