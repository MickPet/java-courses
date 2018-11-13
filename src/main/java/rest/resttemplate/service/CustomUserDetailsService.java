/*
package rest.resttemplate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.resttemplate.model.User;

import java.util.HashSet;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    public CustomUserDetailsService() {
    }

    //@Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        */
/*User user = userService.getUserByName(username);
        Set<GrantedAuthority> authorities = new HashSet<>(user.getRoles());

        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), authorities);*//*

        User user = userDAO.getUserByName(username);

        if (user == null) {
            throw new UsernameNotFoundException("Username " + username + " not found");
        }
        return user;
    }
}*/
