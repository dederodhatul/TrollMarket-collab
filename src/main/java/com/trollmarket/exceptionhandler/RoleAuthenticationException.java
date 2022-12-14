package com.trollmarket.exceptionhandler;

import org.springframework.security.core.AuthenticationException;

import javax.management.relation.Role;

public class RoleAuthenticationException extends AuthenticationException {
    public RoleAuthenticationException(String msg){
        super(msg);
    }
}
