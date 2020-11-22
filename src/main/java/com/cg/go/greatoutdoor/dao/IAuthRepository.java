package com.cg.go.greatoutdoor.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.go.greatoutdoor.entity.Userdata;

public interface IAuthRepository extends JpaRepository<Userdata,Integer> {
    Optional<Userdata>  findByUserName(String userName);
}