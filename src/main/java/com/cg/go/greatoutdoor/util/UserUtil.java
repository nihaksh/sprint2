package com.cg.go.greatoutdoor.util;







import org.springframework.stereotype.Component;

import com.cg.go.greatoutdoor.dto.user.CreateUserRequest;
import com.cg.go.greatoutdoor.entity.Userdata;


@Component
public class UserUtil {

    public CreateUserRequest toUserDetails(Userdata user){
    	CreateUserRequest userDetails=new CreateUserRequest(user.getUserName(),user.getUserType(),user.getUserPassword());
        return userDetails;
    }
}