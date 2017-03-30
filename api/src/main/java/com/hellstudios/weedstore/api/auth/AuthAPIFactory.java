package com.hellstudios.weedstore.api.auth;

import com.hellstudios.weedstore.api.APIFactory;

/**
 * @author strel
 */
public class AuthAPIFactory implements APIFactory<AuthAPI> {

    @Override
    public AuthAPI createAPI() {
        return new AuthAPIImpl();
    }
}
