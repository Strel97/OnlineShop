package com.hellstudios.weedstore.core.util;

import java.util.Calendar;

/**
 * @author strel
 */
public class Token {

    private String token;
    private Calendar expires;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Calendar getExpires() {
        return expires;
    }

    public void setExpires(Calendar expires) {
        this.expires = expires;
    }

    @Override
    public String toString() {
        return "[ " +
                "token='" + token + '\'' +
                ", expires=" + expires +
                " ]";
    }
}
