package com.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
private static Map<String, User> userMap = new HashMap<String, User>();
    static {
    	Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
    	grantedAuthorities.add(new SimpleGrantedAuthority("admin"));
        User user = new User("admin", "123456", grantedAuthorities);
        userMap.put(user.getUsername(), user);
    	Set<GrantedAuthority> grantedAuthorities2 = new HashSet<>();
    	grantedAuthorities2.add(new SimpleGrantedAuthority("user"));
        user = new User("selfly", "123456", grantedAuthorities2);
        userMap.put(user.getUsername(), user);
    }
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMap.get(s);
        if (user == null) {
            throw new UsernameNotFoundException("not found");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getUsername()));
//        LOG.info("username:{},role:{}", user.getUsername(), user.getRole());
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                authorities);
    }
}