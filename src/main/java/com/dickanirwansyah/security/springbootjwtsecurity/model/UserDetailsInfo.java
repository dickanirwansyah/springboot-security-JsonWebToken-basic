package com.dickanirwansyah.security.springbootjwtsecurity.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDetailsInfo implements UserDetails{

    private String userName;
    private String token;
    private Long id;
    private Collection<?extends GrantedAuthority> authorities;

    public UserDetailsInfo(String userName, long id, String token, List<GrantedAuthority> grantedAuthorities){
        this.userName = this.userName;
        this.token = this.token;
        this.id = this.id;
        this.authorities = grantedAuthorities;
    }

    public String getUserName(){
        return userName;
    }

    public String getToken(){
        return token;
    }

    public Long getId(){
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
