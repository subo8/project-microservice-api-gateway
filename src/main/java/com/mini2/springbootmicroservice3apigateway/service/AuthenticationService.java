package com.mini2.springbootmicroservice3apigateway.service;

import com.mini2.springbootmicroservice3apigateway.model.User;

public interface AuthenticationService {
    User signInAndReturnJWT(User signInRequest);
}
