package com.example.ibankauth.service;

import com.example.ibankauth.entity.Users;
import com.example.ibankauth.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username){
        Users users = usersRepository.findByUsername(username);
        if(users == null){
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(users);
    }

}
