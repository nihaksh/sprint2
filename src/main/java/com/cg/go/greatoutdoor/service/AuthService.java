package com.cg.go.greatoutdoor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.go.greatoutdoor.dao.IAuthRepository;

import com.cg.go.greatoutdoor.dto.user.UserSignUpResponse;
import com.cg.go.greatoutdoor.entity.Userdata;
import com.cg.go.greatoutdoor.exception.UserAlreadyExistsException;
import com.cg.go.greatoutdoor.exception.UserNotFoundException;

@Service
public class AuthService  {

	   @Autowired
	    private IAuthRepository authRepository;
	   

	    public UserSignUpResponse userSignUp(Userdata users) {
	 	   List<String> roles = new ArrayList<String>();
	 	   roles.add("ROLE_ADMIN");
	 	   roles.add("ROLE_USER");
	    	Optional<Userdata> userData = authRepository.findByUserName(users.getUserName());
	    	if(userData.isEmpty()) {
	    		if(roles.contains(users.getUserType())){
		    		authRepository.save(users);
		    		return new UserSignUpResponse( "User Created Succefully",authRepository.findByUserName(users.getUserName()));
	    		}else {
		    		return new UserSignUpResponse( " Role must be 'ADMIN' or 'USER'",null);
	    		}
	    	}else {	
	    		return new UserSignUpResponse( "User already existed",null);
	    	}
	         
	        
	    }	

}
