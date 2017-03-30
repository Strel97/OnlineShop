package com.hellstudios.weedstore.core.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * @author strel
 */
public class TokenUtil {

    private static final Random random = new Random();
    private static final String CHARS = "abcdefghijkmnopqrstuvwxyzABCDEFGHJKLMNOPQRSTUVWXYZ234567890!@#$";
    private static final int DEFAULT_LENGTH = 10;

    public static Token generateToken(int length) {
        StringBuilder tokenString = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            tokenString.append(CHARS.charAt(random.nextInt(CHARS.length())));
        }

        // Generating expiration date for 1 day from now
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 1);

        Token token = new Token();
        token.setToken(tokenString.toString());
        token.setExpires(c);

        return token;
    }

    public static Token generateToken() {
        return generateToken(DEFAULT_LENGTH);
    }
}
