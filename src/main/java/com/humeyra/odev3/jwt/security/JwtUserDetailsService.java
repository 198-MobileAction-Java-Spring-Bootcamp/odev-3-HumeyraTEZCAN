package com.humeyra.odev3.jwt.security;


import com.humeyra.odev3.usr.entity.UsrUser;
import com.humeyra.odev3.usr.service.entityservice.UsrUserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final UsrUserEntityService usrUserEntityService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UsrUser usrUser = usrUserEntityService.findByUsername(username);

        return JwtUserDetails.create(usrUser);
    }

    public UserDetails loadByUserId(Long id){

        UsrUser usrUser = usrUserEntityService.findByIdWithControl(id);

        return JwtUserDetails.create(usrUser);
    }
}
