package ru.vlsu.animalSpecification.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link SecurityService} interface
 */

@Service
public class SecurityServiceImpl implements SecurityService{


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    public SecurityServiceImpl(AuthenticationManager authenticationManager, UserDetailsService userDetailsService){
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public String findLoggedInUsername() {
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if(userDetails instanceof UserDetails){
            //ЛООООООООГИ
            //TODO logs
            return ((UserDetails) userDetails).getUsername();
        }
        return null;
    }

    @Override
    public void autoLogin(String userName, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        authenticationManager.authenticate(authenticationToken);

        if(authenticationToken.isAuthenticated()){
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            //TODO logs
        }
    }


}
