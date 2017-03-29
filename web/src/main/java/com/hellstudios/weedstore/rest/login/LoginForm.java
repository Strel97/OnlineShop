package com.hellstudios.weedstore.rest.login;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author strel
 */
@XmlRootElement
public class LoginForm implements Serializable {
    private static final long serialVersionUID = -8328506054685528494L;

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginForm{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
