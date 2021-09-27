package com.company.spring_jsp.security;

import com.company.spring_jsp.data.dao.UserDao;
import com.company.spring_jsp.data.entity.User;
import com.company.spring_jsp.data.entity.UserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    public static final Logger LOG = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userDao.findUserByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("Username '" + username + "' not found in database");
        }

        //List<UserRole> userRoles = userDao.getUserRolesById_2(user.getId());
        List<UserRole> userRoles = userDao.getUserRolesById(user.getId());

        // check the account status
        boolean accountIsEnabled = true;
        //accountIsEnabled = user.isActive();

        // spring security configs
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        // setup user roles
        // List<Permission> permissions = userDao.getPermissionsByEmail(username);
        // Collection<? extends GrantedAuthority> springRoles = buildGrantAuthorities(permissions);
        Collection<? extends GrantedAuthority> springRoles = buildGrantAuthorities(userRoles);

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), accountIsEnabled, accountNonExpired, credentialsNonExpired, accountNonLocked, springRoles);
    }

    //	private Collection<? extends GrantedAuthority> buildGrantAuthorities(List<Permission> permissions) {
    //		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    //		for (Permission permission : permissions) {
    //			authorities.add(new SimpleGrantedAuthority(permission.getName()));
    //		}
    //
    //		return authorities;
    //	}

    private Collection<? extends GrantedAuthority> buildGrantAuthorities(List<UserRole> userRoles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (UserRole role : userRoles) {
            //authorities.add(new SimpleGrantedAuthority(role.getRole().toString()));
            authorities.add(new SimpleGrantedAuthority(role.getRole().toString()));
        }

        // always add the user role
        authorities.add(new SimpleGrantedAuthority("USER"));

        return authorities;
    }
}
