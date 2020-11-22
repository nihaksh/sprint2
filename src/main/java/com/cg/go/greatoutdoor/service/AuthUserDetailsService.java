package com.cg.go.greatoutdoor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.cg.go.greatoutdoor.dao.IAuthRepository;
import com.cg.go.greatoutdoor.entity.GetUserDetailsEntity;
import com.cg.go.greatoutdoor.entity.Userdata;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
@Service
public class AuthUserDetailsService  implements UserDetailsService {
    @Autowired
    private IAuthRepository authRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Userdata> userDetails = authRepo.findByUserName(username);
        userDetails.orElseThrow(new Supplier<UsernameNotFoundException>() {
            @Override
            public UsernameNotFoundException get() {
                return new UsernameNotFoundException("User Not Found " + username);
            }
        });
        return userDetails.map(new Function<Userdata, GetUserDetailsEntity>() {
            @Override
            public GetUserDetailsEntity apply(Userdata userDetails1) {
                return new GetUserDetailsEntity(userDetails1);
            }
        }).get();
    
    }

}
