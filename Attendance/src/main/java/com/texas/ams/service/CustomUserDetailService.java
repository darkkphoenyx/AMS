package com.texas.ams.service;

import com.texas.ams.enums.Role;
import com.texas.ams.model.User;
import com.texas.ams.repo.UserRepo;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepo userRepo;

    public CustomUserDetailService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User myDBuser = userRepo.findByUsername(username).orElseThrow(
                ()->new RuntimeException("Bad Credentials.")
        );
        return new org.springframework.security.core.userdetails.User(
                myDBuser.getUsername(),
                myDBuser.getPassword(),
                getAuthorities(myDBuser.getRole())
        );
    }

    public Set<SimpleGrantedAuthority> getAuthorities(Role role) {
        Set<SimpleGrantedAuthority> roleSet= new HashSet<>();
        SimpleGrantedAuthority myRole= new SimpleGrantedAuthority("ROlE_"+role.name());
        roleSet.add(myRole);
        return roleSet;
    }

}
